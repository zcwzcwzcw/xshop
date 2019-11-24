package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.constant.StatusCode;
import com.xshop.entity.BusinessException;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.GoodsDTO;
import com.xshop.pojo.goods.Spu;
import com.xshop.service.goods.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@Api(tags = "spu控制器类")
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Reference
    private SpuService spuService;

    @GetMapping("/findAll")
    public List<Spu> findAll() {
        return spuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Spu> findPage(int page, int size) {
        return spuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Spu> findList(@RequestBody Map<String, Object> searchMap) {
        return spuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Spu> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return spuService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Spu findById(String id) {
        return spuService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Spu spu) {
        spuService.add(spu);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Spu spu) {
        spuService.update(spu);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(String id) {
        spuService.delete(id);
        return CommonResponse.success();
    }

    @ApiOperation("添加或修改商品")
    @PostMapping("/saveGoods")
    public CommonResponse saveGoods(@RequestBody GoodsDTO goodsDTO) {
        spuService.saveGoods(goodsDTO);
        return CommonResponse.success();
    }

    @ApiOperation("根据spuId查询商品")
    @GetMapping("/findGoodsBySpuId")
    public CommonResponse findGoodsBySpuId(String spuId) {
        if (StringUtils.isBlank(spuId)) {
            throw new BusinessException(StatusCode.PARAMETER_MISSING);
        }
        GoodsDTO goods = spuService.findGoodsBySpuId(spuId);
        return CommonResponse.success(goods);
    }

    @ApiOperation("商品审核")
    @PostMapping("/audit")
    public CommonResponse audit(String spuId, String status, String message) {
        spuService.audit(spuId, status, message);
        return CommonResponse.success();
    }

    @ApiOperation("商品下架")
    @PostMapping("/pull")
    public CommonResponse pull(String spuId) {
        spuService.pull(spuId);
        return CommonResponse.success();
    }

    @ApiOperation("商品上架")
    @PostMapping("/put")
    public CommonResponse put(String spuId) {
        spuService.put(spuId);
        return CommonResponse.success();
    }

    @ApiOperation("商品批量上架")
    @PostMapping("/putMany")
    public CommonResponse putMany(List<String> spuIds) {
        int count = spuService.putMany(spuIds);
        return CommonResponse.success(count);
    }
}
