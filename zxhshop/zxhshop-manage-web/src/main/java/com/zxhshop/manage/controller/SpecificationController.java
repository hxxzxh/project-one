package com.zxhshop.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zxhshop.pojo.TbSpecification;
import com.zxhshop.sellergoods.service.SpecificationService;
import com.zxhshop.vo.PageResult;
import com.zxhshop.vo.Result;
import com.zxhshop.vo.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/specification")
@RestController
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        return specificationService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return specificationService.findPage(page, rows);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Specification specification) {
        try {
            specificationService.add(specification);
            return Result.ok("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("增加失败");
    }


    /*@PostMapping("/add")
    public Result add(@RequestBody TbSpecification specification) {
        try {
            specificationService.add(specification);
            return Result.ok("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("增加失败");
    }*/


    @GetMapping("/findOne")
    public Specification findOne(Long id) {
        return specificationService.findOne(id);
    }

    /*@GetMapping("/findOne")
    public TbSpecification findOne(Long id) {
        return specificationService.findOne(id);
    }*/

    @PostMapping("/update")
    public Result update(@RequestBody Specification specification) {
        try {
            specificationService.update(specification);
            return Result.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("修改失败");
    }

    /*@PostMapping("/update")
    public Result update(@RequestBody TbSpecification specification) {
        try {
            specificationService.update(specification);
            return Result.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("修改失败");
    }*/


    @GetMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationService.deletespecificationByIds(ids);
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除失败");
    }

/*
    @GetMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationService.deleteByIds(ids);
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除失败");
    }
*/

    /**
     * 分页查询列表
     *
     * @param specification 查询条件
     * @param page          页号
     * @param rows          每页大小
     * @return
     */
    @PostMapping("/search")
    public PageResult search(@RequestBody TbSpecification specification, @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return specificationService.search(page, rows, specification);
    }

    @GetMapping("/selectOptionList")
    public List<Map<String, Object>> selectOptionList(){
        return specificationService.selectOptionList();
    }


}
