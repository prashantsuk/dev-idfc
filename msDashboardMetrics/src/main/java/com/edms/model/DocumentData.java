package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentData {

	private String edmsId;
	private String docTitle;
	private String docClass;
	private String docType;
	private String docName;
	private String custName;
	private String ucic;
	private String acctNum;
	private String barCodeNum;
	private String fileSize;
	private String fileType;
	private String noOfPages;
	private String owner;
	private String mobNo;
	private String remarks;
	private String docNum;
	private String comments;
	private String multipageDoc;
	private String source;
	private String uploadDate;
	private String modifiedDate;
	private String expiryDate;
	private String acceptedDate;
	private String createdDate;
	private String createdBy;
	private String acceptedBy;
	private String docEncrypt;
}
