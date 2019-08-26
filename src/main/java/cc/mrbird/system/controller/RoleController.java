package cc.mrbird.system.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cc.mrbird.common.util.MyExecelUtils;
import cc.mrbird.system.domain.Roles;
import cc.mrbird.system.domain.TestUser;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.Role;
import cc.mrbird.system.service.RoleService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	@Log("获取角色信息")
	@RequestMapping("role")
	@RequiresPermissions("role:list")
	public String index() {
		return "system/role/role";
	}

	@RequestMapping("role/list")
	@ResponseBody
	public Map<String, Object> roleList(QueryRequest request, Role role) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<Role> list = this.roleService.findAllRole(role);
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		return getDataTable(pageInfo);
	}
	
	@RequestMapping("role/excelb")
	@ResponseBody
	public ResponseBo roleExcel(Role role) {
		try {
			//List<Role> list = this.roleService.findAllRole(role);
			List<Roles> list=new ArrayList<>();
			for(int a=0;a<6;a++){
				Roles role1 =new Roles();
				role1.setRoleId(Long.parseLong(a+""));
				role1.setRoleName("roleName"+a);
				role1.setModifyTime(new Date());
				role1.setRemark("remark"+a);
                list.add(role1);
			}
			List<TestUser> users =new ArrayList<>();
			for(int i =0;i<4;i++){
				TestUser testUser =new TestUser();
				testUser.setUserName("testName"+i);
				testUser.setUserDep("testDep"+i);
				users.add(testUser);
			}

			for(Roles role1 :list){
				role1.setUsers(users);
			}

			return FileUtils.createExcelByPOIKit("角色表", list, Roles.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
		}

	}


	@RequestMapping("role/excel")
	@ResponseBody
	public ResponseBo roleExcel2(Role role, HttpServletResponse response) throws Exception {

			//List<Role> list = this.roleService.findAllRole(role);
			List<Roles> list = new ArrayList<>();
			for (int a = 0; a < 6; a++) {
				Roles role1 = new Roles();
				role1.setRoleId(Long.parseLong(a + ""));
				role1.setRoleName("roleName" + a);
				role1.setModifyTime(new Date());
				role1.setCreateTime(new Date());
				role1.setRemark("remark" + a);
				list.add(role1);
			}
			List<TestUser> users = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				TestUser testUser = new TestUser();
				testUser.setUserName("2019-07-1" + i);
				testUser.setUserDep("testDep" + i);
				users.add(testUser);
			}

			for (Roles role1 : list) {
				role1.setUsers(users);
			}

			List<String> strings = new ArrayList<>();
		   // strings.add("第一列");
			strings.add("第一列");
			strings.add("角色id");
			strings.add("角色标识");
			strings.add("角色创建时间");
			strings.add("角色确定时间时间");
			for (TestUser testUser : users) {
				strings.add(testUser.getUserName());
			}


			String[] rowsName = new String[strings.size()];
			for (int k = 0; k < strings.size(); k++) {
				rowsName[k] = strings.get(k);
			}


			List<Object[]> dataList = new ArrayList<>();
			Object[] objs = null;
			for (int i = 0; i < list.size(); i++) {
				Roles main = list.get(i);
				objs = new Object[rowsName.length];
				objs[0] = i;
				objs[1] =  main.getRoleId();

				objs[2] = main.getRemark();

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date1 = df.format(main.getCreateTime());
				objs[3] = date1;
				String date2 = df.format(main.getModifyTime());
				objs[4] = date2;
				try {
					for (int y = 0; y< main.getUsers().size(); y++) {
						int p=5+y;
						objs[p] = main.getUsers().get(y).getUserDep();

					}

				}catch (ArrayIndexOutOfBoundsException a){

				}
				dataList.add(objs);
			}

			MyExecelUtils ex = new MyExecelUtils("角色表", rowsName, dataList);
			ex.export(response);

		return  ResponseBo.ok();
	}

	@RequestMapping("role/csv")
	@ResponseBody
	public ResponseBo roleCsv(Role role){
		try {
			List<Role> list = this.roleService.findAllRole(role);
			return FileUtils.createCsv("角色表", list, Role.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
		}
	}
	
	@RequestMapping("role/getRole")
	@ResponseBody
	public ResponseBo getRole(Long roleId) {
		try {
			Role role = this.roleService.findRoleWithMenus(roleId);
			return ResponseBo.ok(role);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
		}
	}

	@RequestMapping("role/checkRoleName")
	@ResponseBody
	public boolean checkRoleName(String roleName, String oldRoleName) {
		if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
			return true;
		}
		Role result = this.roleService.findByName(roleName);
		if (result != null)
			return false;
		return true;
	}

	@Log("新增角色")
	@RequiresPermissions("role:add")
	@RequestMapping("role/add")
	@ResponseBody
	public ResponseBo addRole(Role role, Long[] menuId) {
		try {
			this.roleService.addRole(role, menuId);
			return ResponseBo.ok("新增角色成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("新增角色失败，请联系网站管理员！");
		}
	}

	@Log("删除角色")
	@RequiresPermissions("role:delete")
	@RequestMapping("role/delete")
	@ResponseBody
	public ResponseBo deleteRoles(String ids) {
		try {
			this.roleService.deleteRoles(ids);
			return ResponseBo.ok("删除角色成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("删除角色失败，请联系网站管理员！");
		}
	}

	@Log("修改角色")
	@RequiresPermissions("role:update")
	@RequestMapping("role/update")
	@ResponseBody
	public ResponseBo updateRole(Role role, Long[] menuId) {
		try {
			this.roleService.updateRole(role, menuId);
			return ResponseBo.ok("修改角色成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("修改角色失败，请联系网站管理员！");
		}
	}
}
