package com.zxhshop.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxhshop.mapper.TypeTemplateMapper;
import com.zxhshop.pojo.TbTypeTemplate;
import com.zxhshop.sellergoods.service.TypeTemplateService;
import com.zxhshop.service.impl.BaseServiceImpl;
import com.zxhshop.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = TypeTemplateService.class)
public class TypeTemplateServiceImpl extends BaseServiceImpl<TbTypeTemplate> implements TypeTemplateService {

    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbTypeTemplate typeTemplate) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbTypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(typeTemplate.getName())){
            criteria.andLike("name", "%" + typeTemplate.getName() + "%");
        }

        List<TbTypeTemplate> list = typeTemplateMapper.selectByExample(example);
        PageInfo<TbTypeTemplate> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}