package com.hyb.alpha.controller;

import com.hyb.alpha.domain.bo.ZooBO;
import com.hyb.alpha.domain.request.ZooRequest;
import com.hyb.alpha.exception.AlphaException;
import com.hyb.alpha.form.zoo.ZooCreateForm;
import com.hyb.alpha.form.zoo.ZooQueryForm;
import com.hyb.alpha.form.zoo.ZooUpdateForm;
import com.hyb.alpha.response.CentreCutPageResponse;
import com.hyb.alpha.service.ZooService;
import com.hyb.alpha.util.CopyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: example for RESTful API Controller
 * @author: Yibo
 * @create: 2018/8/3
 **/
@Api(value="/v1/zoos", tags="RESTful API 示例")
@RestController
@RequestMapping("/v1/zoos")
public class SwaggerController extends BaseController{

    @Autowired
    private ZooService zooService;

    @ApiOperation(value="列出所有动物园", notes = "GET /zoos：列出所有动物园")
    @GetMapping
    @ResponseBody
    public Map<String, Object> getZoos(@ModelAttribute @Valid ZooQueryForm form) throws AlphaException {
        ZooRequest request = CopyUtil.transfer(form, ZooRequest.class);

        int count = zooService.queryCount(request);
        List<ZooBO> zooBOList;
        if(count == 0) {
            zooBOList = new ArrayList<>();
            return successDataResult(zooBOList);
        }

        zooBOList = zooService.queryList(request);
        CentreCutPageResponse<ZooBO> response = new CentreCutPageResponse<>();
        response.setTotalCount(count);
        response.setDataList(zooBOList);
        return successDataResult(response);
    }

    @ApiOperation(value="新建一个动物园", notes = "POST /zoos：新建一个动物园")
    @PostMapping
    @ResponseBody
    public Map<String, Object> createZoo(@ModelAttribute @Valid ZooCreateForm form) throws AlphaException{
        ZooBO zooBO = CopyUtil.transfer(form, ZooBO.class);
        zooService.insertWithValid(zooBO);
        return successResult("创建成功!");
    }

    @ApiOperation(value="获取某个指定动物园的信息", notes = "GET /zoos/ID：获取某个指定动物园的信息")
    @GetMapping("/ID")
    @ResponseBody
    public Map<String, Object> getZooById(@ApiParam(value = "动物园编号", required = true) @RequestParam Integer id) throws AlphaException{
        return successDataResult(zooService.queryWithValid(id)) ;
    }

    @ApiOperation(value="更新某个指定动物园的信息（提供该动物园的全部信息）", notes = "PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）")
    @PutMapping("/ID")
    @ResponseBody
    public Map<String, Object> updateZoo(@ModelAttribute @Valid ZooUpdateForm form) throws AlphaException{
        zooService.queryWithValid(form.getId());
        ZooBO zooBO = CopyUtil.transfer(form, ZooBO.class);
        zooService.updateWithValid(zooBO);
        return successResult("更新成功!");
    }

    @ApiOperation(value="更新某个指定动物园的信息（提供该动物园的部分信息）", notes = "PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）")
    @PatchMapping("/ID")
    @ResponseBody
    public Map<String, Object> patchZoo(@ModelAttribute @Valid ZooUpdateForm form) throws AlphaException{
        zooService.queryWithValid(form.getId());
        ZooBO zooBO = CopyUtil.transfer(form, ZooBO.class);
        zooService.updateWithValid(zooBO);
        return successResult("更新成功!");
    }

    @ApiOperation(value="删除某个动物园", notes = "DELETE /zoos/ID：删除某个动物园")
    @DeleteMapping("/ID")
    @ResponseBody
    public Map<String, Object> delZoo(@ApiParam(value = "动物园编号", required = true) @RequestParam Integer id) throws AlphaException{
        zooService.queryWithValid(id);
        zooService.fakeDelete(id);
        return successResult("删除成功!");
    }

}