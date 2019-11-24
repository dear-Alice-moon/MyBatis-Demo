package com.moon.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.mybatis.pojo.SysDict;
import com.moon.mybatis.service.SysDictService;

@Controller
@RequestMapping("/dicts")
public class SysDictController {
	
	@Autowired
	private SysDictService sysDictService;
	
	
	/**
	 * 显示字典数据列表
	 * 
	 * @param sysDict
	 * @param offset
	 * @param limit
	 * @return
	 * 
	 * @author moon  2019/11/16  20:40
	 */
	@RequestMapping
	public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {
		
		ModelAndView mv = new ModelAndView("dicts");
		List<SysDict> dicts = sysDictService.selectBySysDict(sysDict, offset, limit);
		mv.addObject("dicts", dicts);
		
		return mv;
	}
	
	
	/**
	 * 新增或修改字典信息页面，使用 get 跳转到页面.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(Long id) {
		
		ModelAndView mv = new ModelAndView("dict_add");
		SysDict sysDict;
		
		if (id == null) {
			
			// 如果id不存在，就是新增数据，创建一个空对象即可。
			sysDict = new SysDict();
		} else {
			
			// 如果id存在，就是修改数据，把原有的数据查询出来。
			sysDict = sysDictService.selectByPrimaryKey(id);
		}
		
		mv.addObject("model", sysDict);
		
		return mv;
	}
	
	
	/**
	 * 新增或修改字典信息，通过表单 post 提交数据.
	 * 
	 * @param sysDict
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView save(SysDict sysDict) {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			
			sysDictService.saveOrUpdateSysDict(sysDict);
			mv.setViewName("redirect:/dicts");
		} catch (Exception e) {
			
			mv.setViewName("dict_add");
			mv.addObject("msg", e.getMessage());
			mv.addObject("model", sysDict);
		}
		
		return mv;
	}
	
	
	/**
	 * 通过id删除字典信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/11/16  21:08
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap delete(@RequestParam Long id) {
		
		ModelMap modelMap = new ModelMap();
		
		try {
			
			boolean success = sysDictService.deleteSysDictById(id);
			modelMap.put("success", success);
			
		} catch (Exception e) {
			
			modelMap.put("success", false);
			modelMap.put("msg", e.getMessage());
		}
		
		return modelMap;
	}
	
	
}
