import logging
import yaml
import argparse
import py_eureka_client.eureka_client as eureka_client
from logging.handlers import TimedRotatingFileHandler
from flask import Flask, request
from dms_compressor import dms_compress
from dms_blob_uploader import blob_uploader

app = Flask(__name__)

rest_port = 9003
eureka_client.init(eureka_server="http://52.140.58.184:8761:8761/eureka",
                   app_name="msDocumentCompressionService",
                   instance_port=rest_port)

app = Flask(__name__)


@app.route("/compressFile", methods=['POST'])
def compressFile():
    if request.method == 'POST':  # sample {"file":"base64_stream", "extention":"base64_extention,"name":"base"}
        base64_stream = request.json["fileContent"]  # baseKey
        blob_upload_dir = request.json["filePath"]  # dir
        name_extention = blob_upload_dir.split("/")[-1].split(".")
        base64_extention = "." + name_extention[-1]
        base64_name = ".".join(name_extention[:-1])
        if base64_stream:  # processing only if data streams : None by default
            try:
                originalSize,  compression_status,compress_data_dir, compressedSize, pageCount = dms_compress_obj.main(base64_stream,
                                                                                                    base64_extention,
                                                                                                    base64_name)
                upload_status = blob_uploader_obj.uploadToBlobStorage(compress_data_dir,blob_upload_dir)

                return {"originalSize": str(round(originalSize, 2)) + " MB", 'compressionStatus': compression_status,
                        "compressedSize": str(round(compressedSize, 2)) + " MB", "pageCount": pageCount, "blobUploadStatus":upload_status}
            except:
                return {"originalSize": 0, 'compressionStatus': False, "compressedSize": 0, "pageCount": 0,"blobUploadStatus":False}

#
if __name__ == '__main__':
    log_filename = 'dms_compressor.log'
    logging.getLogger().setLevel(logging.ERROR)
    logger = logging.getLogger('logger')
    logger.setLevel(logging.INFO)
    handler = TimedRotatingFileHandler(log_filename, when="midnight", backupCount=4)
    handler.setFormatter(logging.Formatter('%(asctime)s - %(levelname)s - %(message)s'))
    logger.addHandler(handler)
    logger.info("started processing")
    parser = argparse.ArgumentParser(description='Compression Test')
    opt = parser.parse_args()
    # all static and dynamic variable declared in opts.yaml file
    with open('opts.yaml', 'r') as variable_loader:
        config = yaml.load(variable_loader, Loader=yaml.FullLoader)
    opt.source_dir = config['source_dir']
    opt.base64_decrypt = config['base64_decrypt']
    opt.destin_dir = config['destin_dir']
    opt.process_type_checker = config['process_type_checker']
    opt.zero_val = config['zero_val']
    opt.one_val = config["one_val"]
    opt.scale_percentage = config["scale_percentage"]
    opt.cent_val = config["cent_val"]
    opt.pdf_quality = config['pdf_quality']
    opt.image_dirPath = config['image_dirPath']
    opt.graphicData = config['graphicData']
    #blob creds
    opt.storage_account_key = config["storage_account_key"]
    opt.storage_account_name = config['storage_account_name']
    opt.connection_string = config['connection_string']
    opt.container_name = config['container_name']
    # creating a compress class object#
    dms_compress_obj = dms_compress(opt, logger)
    blob_uploader_obj = blob_uploader(opt, logger)
    app.run(host='0.0.0.0', port=rest_port)