package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * Controller class for Role operations.
 * Provides APIs for managing role-related data.
 *
 * @author Saket
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {

}