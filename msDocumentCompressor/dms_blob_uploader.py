from azure.storage.blob import BlobServiceClient

class blob_uploader:

   def __init__(self, opt, logger):
      self.opt = opt
      self.logger = logger
   def uploadToBlobStorage(self, file_path,file_name):
      blob_service_client = BlobServiceClient.from_connection_string(self.opt.connection_string)
      blob_client = blob_service_client.get_blob_client(container=self.opt.container_name, blob=file_name)
      try:
         with open(file_path,'rb') as data:
            blob_client.upload_blob(data,overwrite=True)
            return True
      except:
         "faiiled"
