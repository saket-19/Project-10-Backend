package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * DTO class representing Attachment entity.
 * Stores file information such as name, type,
 * description, user reference, and document content.
 *
 * @author Saket
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

	@Column(name = "NAME", length = 100)
	protected String name = null;

	@Column(name = "TYPE", length = 100)
	protected String type = null;

	@Column(name = "DESCRIPTION", length = 500)
	protected String description = null;

	@Column(name = "USER_ID")
	protected Long userId = null;

	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	/**
	 * Default constructor.
	 */
	public AttachmentDTO() {
	}

	/**
	 * Creates an AttachmentDTO from uploaded file.
	 *
	 * @param file Multipart file
	 */
	public AttachmentDTO(MultipartFile file) {
		name = file.getOriginalFilename();
		type = file.getContentType();

		try {
			doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns file name.
	 *
	 * @return File name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets file name.
	 *
	 * @param name File name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns file type.
	 *
	 * @return File type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets file type.
	 *
	 * @param type File type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns description.
	 *
	 * @return Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description.
	 *
	 * @param description Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns user id.
	 *
	 * @return User ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets user id.
	 *
	 * @param userId User ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Returns display value.
	 *
	 * @return Value
	 */
	@Override
	public String getValue() {
		return null;
	}

	/**
	 * Returns document bytes.
	 *
	 * @return Document content
	 */
	public byte[] getDoc() {
		return doc;
	}

	/**
	 * Sets document bytes.
	 *
	 * @param doc Document content
	 */
	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	/**
	 * Returns unique key field name.
	 *
	 * @return Unique key
	 */
	@Override
	public String getUniqueKey() {
		return null;
	}

	/**
	 * Returns unique value.
	 *
	 * @return Unique value
	 */
	@Override
	public String getUniqueValue() {
		return null;
	}

	/**
	 * Returns display label.
	 *
	 * @return Label
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name.
	 *
	 * @return Table name
	 */
	@Override
	public String getTableName() {
		return null;
	}
}