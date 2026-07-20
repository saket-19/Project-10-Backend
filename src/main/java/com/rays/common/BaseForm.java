package com.rays.common;

/**
 * Base form class used for transferring data between UI and backend.
 * Contains common fields like id, audit info, pagination, and operations.
 *
 * @author Saket
 */
public class BaseForm {

	protected Long id;

	protected String createdBy;

	protected String modifiedBy;

	protected long createdDatetime;

	protected long modifiedDatetime;

	private Long[] ids;

	private int pageNo = 0;

	private int pageSize = 5;

	private String operation;

	/**
	 * Returns entity ID.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets entity ID.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Converts form into DTO.
	 * Should be overridden in child classes.
	 */
	public BaseDTO getDto() {
		return null;
	}

	/**
	 * Initializes DTO with common base properties.
	 *
	 * @param dto entity object
	 * @return initialized DTO
	 */
	public <T extends BaseDTO> T initDTO(T dto) {
		System.out.println("id => base dto => " + id);

		if (id != null && id > 0) {
			dto.setId(id);
		} else {
			dto.setId(null);
		}
		return dto;
	}
}