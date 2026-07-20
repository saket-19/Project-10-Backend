package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * Implementation class for Attachment service operations.
 * Provides business logic for managing attachment records.
 *
 * @author Saket
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentDTO, AttachmentDAOInt>
		implements AttachmentServiceInt {

}