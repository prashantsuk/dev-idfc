package com.edms.model;


import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test",set = "edp_liabilities")
public class LiabilitiesEntity {

	@AerospikeKey
	@AerospikeBin(name = "PK")
	private long pk;
	
	@AerospikeBin(name = "ACCEPTEDBY")
	private String acceptedBy;
	
	@AerospikeBin(name = "ACCEPTEDDATE")
	private String acceptedDate;
	
	@AerospikeBin(name = "ACCESSEDDATE")
	private String accessedDate;
	
	@AerospikeBin(name = "ACCESSTYPE")
	private String accessType;
	
	@AerospikeBin(name = "ACCOUNTNUMBER")
	private String accountNo;
	
	@AerospikeBin(name = "ACL")
	private String acl;

	@AerospikeBin(name = "ACLMOREFLAG")
	private String aclMoreFlag;
	
	@AerospikeBin(name = "ACTUALFILESIZE")
	private String actualFileSize;
	
	@AerospikeBin(name = "APISTATUS")
	private String apiStatus;
	
	@AerospikeBin(name = "APPNAME")
	private String appName;
	
	@AerospikeBin(name = "AUTHOR")
	private String author;
	
	@AerospikeBin(name = "BARCODENO")
	private String barcodeNo;
	
	@AerospikeBin(name = "BRANCHID")
	private String branchId;
	
	@AerospikeBin(name = "CATEGORY")
	private String category;
	
	@AerospikeBin(name = "CHECKOUTBYUSER")
	private String checkoutByUser;
	
	@AerospikeBin(name = "CHECKOUTSTATUS")
	private String checkoutStatus;
	
	@AerospikeBin(name = "COMMENTS")
	private String comments;
	
	@AerospikeBin(name = "COMPRESFILESIZE")
	private String compresFileSize;
	
	@AerospikeBin(name = "CREATEBYAPPNAME")
	private String createByAppName;
	
	@AerospikeBin(name = "CREATEDBY")
	private String createdBy;
	
	@AerospikeBin(name = "CREATEDBYAPP")
	private String createdByApp;
	
	@AerospikeBin(name = "CREATEDBYUSER")
	private String createdByUser;
	
	@AerospikeBin(name = "CREATEDDATE")
	private String createdDate;
	
	@AerospikeBin(name = "CUSTOMERNAME")
	private String customerName;
	
	@AerospikeBin(name = "CUSTOMERID")
	private String customerId;
	
	@AerospikeBin(name = "CUSTOMERTYPE")
	private String customerType;
	
	@AerospikeBin(name = "DATACLASS")
	private String dataClass;
	
	@AerospikeBin(name = "DATADEFINDEX")
	private String dataDefIndx;
	
	@AerospikeBin(name = "DATADEFNAME")
	private String dataDefName;
	
	@AerospikeBin(name = "DELETEDDATE")
	private String deletedDate;
	
	@AerospikeBin(name = "DOCENCRYPTKEY")
	private String docEncryptKey;
	
	@AerospikeBin(name = "DOCEXPIRYDATE")
	private String docExpiryDate;
	
	@AerospikeBin(name = "DOCID")
	private String docId;
	
	@AerospikeBin(name = "DOCINDEX")
	private int docIndex;
	
	@AerospikeBin(name = "DOCPASSWORD")
	private String docPassword;
	
	@AerospikeBin(name = "DOCREMARK")
	private String docRemark;
	
	@AerospikeBin(name = "DOCSTATUS")
	private String docStatus;
	
	@AerospikeBin(name = "DOCTYPEID")
	private int docTypeId;
	
	@AerospikeBin(name = "DOCTYPENAME")
	private String docTypeName;
	
	@AerospikeBin(name = "DOCUMENTINDEX")
	private String documentIndex;
	
	@AerospikeBin(name = "DOCUMENTLOCK")
	private String documentLock;
	
	@AerospikeBin(name = "DOCUMENTNAME")
	private String documentName;
		
	@AerospikeBin(name = "DOCUMENTNO")
	private int documentNumber;
	
	@AerospikeBin(name = "DOCUMENTORDERNO")
	private String documentOrderNo;
	
	@AerospikeBin(name = "DOCUMENTSIZE")
	private String documentSize;
	
	@AerospikeBin(name = "DOCUMENTTITLE")
	private String documentTitle;
	
	@AerospikeBin(name = "DOCUPLOADED")
	private char docUploaded;
	
	@AerospikeBin(name = "DOCUPLOADID")
	private String docUploadId;
	
	@AerospikeBin(name = "DOCUMENTVERSION")
	private int documentVersion;
	
	@AerospikeBin(name = "EDPID")
	private String edpId;
	
	@AerospikeBin(name = "EDPRESPONSE")
	private String edpResponse;
	
	@AerospikeBin(name = "ENABLEFTS")
	private String enableEfts;
	
	@AerospikeBin(name = "ENABLESECURE")
	private String enableSecure;
	
	@AerospikeBin(name = "ENABLEVERSION")
	private String enableVersion;
	
	@AerospikeBin(name = "ENCRYPTPASSWD")
	private String encryptPassword;
	
	@AerospikeBin(name = "ESFLAG")
	private String esFlag;
	
	@AerospikeBin(name = "ESINDEXTIME")
	private String esIndexTime;
	
	@AerospikeBin(name = "ESTIMESTAMP")
	private String esTimeStamp;
	
	@AerospikeBin(name = "EXPIRYDATE")
	private String expiryDate;
	
	@AerospikeBin(name = "FIELD_123")
	private String field123;
	
	@AerospikeBin(name = "FIELD_147")
	private String field147;
	
	@AerospikeBin(name = "FIELD_148")
	private String field148;
	
	@AerospikeBin(name = "FIELD_187")
	private String field187;
	
	@AerospikeBin(name = "FIELD_23")
	private String field23;
	
	@AerospikeBin(name = "FIELD_24")
	private String field24;
	
	@AerospikeBin(name = "FIELD_25")
	private String field25;
	
	@AerospikeBin(name = "FIELD_26")
	private String field26;
	
	@AerospikeBin(name = "FIELD_304")
	private String field304;
	
	@AerospikeBin(name = "FIELD_305")
	private String field305;
	
	@AerospikeBin(name = "FIELD_453")
	private String field453;
	
	@AerospikeBin(name = "FIELD_47")
	private String field47;
	
	@AerospikeBin(name = "FIELD_473")
	private String field473;
	
	@AerospikeBin(name = "FIELD_493")
	private String field494;
	
	@AerospikeBin(name = "FIELD_83")
	private String field83;
	
	@AerospikeBin(name = "FIELD_84")
	private String field84;
	
	@AerospikeBin(name = "FIELD_85")
	private String field85;
	
	@AerospikeBin(name = "FIELD_855")
	private String field855;
	
	@AerospikeBin(name = "FIELD_86")
	private String field86;
	
	@AerospikeBin(name = "FIELD_87")
	private String field87;
	
	@AerospikeBin(name = "FIELD_88")
	private String field88;
	
	@AerospikeBin(name = "FILEDBY")
	private String filedBy;
	
	@AerospikeBin(name = "FILEDDATE")
	private String filedDate;
	
	@AerospikeBin(name = "FILEPATH")
	private String filePath;
	
	@AerospikeBin(name = "FILETYPE")
	private String fileType;
	
	@AerospikeBin(name = "FINALIZEDBY")
	private String finalizedBy;
	
	@AerospikeBin(name = "FINALIZEDDATE")
	private String finalizedDate;
	
	@AerospikeBin(name = "FINALIZEDFLAG")
	private String finalizedFlag;
	
	@AerospikeBin(name = "FOLDDOCFLAG")
	private String foldDocFlag;
	
	@AerospikeBin(name = "FOLDDOCINDEX")
	private String foldDocIndex;
	
	@AerospikeBin(name = "FOLDERINDEX")
	private String folderIndex;
	
	@AerospikeBin(name = "FOLDERLEVEL")
	private String folderLevel;
	
	@AerospikeBin(name = "FOLDERLOCK")
	private String folderLock;
	
	@AerospikeBin(name = "FOLDERNAME")
	private String folderName;
	
	@AerospikeBin(name = "FOLDERTYPE")
	private String folderType;
	
	@AerospikeBin(name = "FTSDOCINDEX")
	private String ftsDocIndex;
	
	@AerospikeBin(name = "FTSFLAG")
	private String ftsFlag;
	
	@AerospikeBin(name = "HISTORYENABLED")
	private String historyEnabled;
	
	@AerospikeBin(name = "HISTORYFLAG")
	private char historyFlag;
	
	@AerospikeBin(name = "IMAGEINDEX")
	private String imageIndx;
	
	@AerospikeBin(name = "IMAGEVOLUMEIDX")
	private String imageVolIndex;
	
	@AerospikeBin(name = "INDEXID")
	private int indexId;
	
	@AerospikeBin(name = "INDEXLENGHTH")
	private int indexLength;
	
	@AerospikeBin(name = "INDEXNAME")
	private String indexName;
	
	@AerospikeBin(name = "INDEXTYPE")
	private String indexType;
	
	@AerospikeBin(name = "INDEXVALUE")
	private int indexValue;
	
	@AerospikeBin(name = "ISINDEX")
	private String isIndex;
	
	@AerospikeBin(name = "LATITUDE")
	private String latitude;
	
	@AerospikeBin(name = "LOCATION")
	private String location;
	
	@AerospikeBin(name = "LOCKBYUSER")
	private String lockByUser;
	
	@AerospikeBin(name = "LOCKMESSAGE")
	private String lockMessage;
	
	@AerospikeBin(name = "LONGITUDE")
	private String longitude;

	@AerospikeBin(name = "MAINGROUPID")
	private String mainGroupId;
	
	@AerospikeBin(name = "MESSAGE")
	private String message;
	
	@AerospikeBin(name = "MIMETYPE")
	private String mimeType;
	
	@AerospikeBin(name = "MOBILENUMBER")
	private long mobileNumber;
	
	@AerospikeBin(name = "MODIFIEDDATE")
	private String modifiedDate;
	
	@AerospikeBin(name = "MULTIPAGEDOC")
	private char multipageDoc;
	
	@AerospikeBin(name = "NAME")
	private String name;
	
	@AerospikeBin(name = "NOOFPAGES")
	private int noOfPages;
	
	@AerospikeBin(name = "ODMADOCINDEX")
	private String odmaDocIndex;
	
	@AerospikeBin(name = "OWNER")
	private String owner;
	
	@AerospikeBin(name = "OWNERINDEX")
	private int ownerIndex;
	
	@AerospikeBin(name = "OWNERINHERIT")
	private String ownerInherit;
	
	@AerospikeBin(name = "OWNERTYPE")
	private String ownerType;
	
	@AerospikeBin(name = "PAGENO")
	private int pageNo;
	
	@AerospikeBin(name = "PARENTFOLDERIDX")
	private String parentFolderIndex;
	
	@AerospikeBin(name = "PHYSICALLOC")
	private String physicalLocation;
	
	@AerospikeBin(name = "PRODUCTID")
	private String productiId;
	
	@AerospikeBin(name = "PRODUCTNAME")
	private String productName;
	
	@AerospikeBin(name = "PULLPRINTFLAG")
	private String pullPrintFlag;
	
	@AerospikeBin(name = "REFERECEFLAG")
	private String refereceFlag;
	
	@AerospikeBin(name = "REIMBURSEACCTNO")
	private String reImburseAcctNo;
	
	@AerospikeBin(name = "REMARKS")
	private String remarks;
	
	@AerospikeBin(name = "REVISEDBY")
	private String revisedBy;
	
	@AerospikeBin(name = "REVISEDDATE")
	private String revisedDate;
	
	@AerospikeBin(name = "ROLENAME")
	private String roleName;
	
	@AerospikeBin(name = "SIGNFLAG")
	private String signFlag;
	
	@AerospikeBin(name = "SOURCEID")
	private int sourceId;
	
	@AerospikeBin(name = "SOURCENAME")
	private String sourceName;
	
	@AerospikeBin(name = "STATUS")
	private String status;
	
	@AerospikeBin(name = "TEXTIMAGEINDEX")
	private String textImageIndex;
	
	@AerospikeBin(name = "TEXTVOLUMEID")
	private String textVolumeId;
	
	@AerospikeBin(name = "THUMBNAILFLAG")
	private String thumbnailFlag;
	
	@AerospikeBin(name = "UCIC")
	private String ucic;
	
	@AerospikeBin(name = "UNIQUEID")
	private String uniqueId;
	
	@AerospikeBin(name = "UPLOADEDBY")
	private String uploadedBy;
	
	@AerospikeBin(name = "UPLOADEDDATE")
	private String uploadedDate;
	
	@AerospikeBin(name = "USEFULDATA")
	private String usefulData;
	
	@AerospikeBin(name = "USERNAME")
	private String userName;
	
	@AerospikeBin(name = "VERSION_STATUS")
	private String versionStatus;
	
	@AerospikeBin(name = "VERSIONCOMMENT")
	private String versionComment;
	
	@AerospikeBin(name = "VERSIONING")
	private String versioning;
	
	@AerospikeBin(name = "VERSIONNUMBER")
	private String versionNumber;
	
	@AerospikeBin(name = "VOLUMEID")
	private String volumeId;
}