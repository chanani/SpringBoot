package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.service.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    // 목록
    @GetMapping("/productList")
    public String list(Model model,
                       Criteria cri) {

        // 로그인 기능이 없으므로, admin이라는 계정기반으로 조회
        String writer = "admin";

        // 1st
        // ArrayList<ProductVO> list = productService.getList(writer);
        // model.addAttribute("list", list);

        // 2nd
        ArrayList<ProductVO> list = productService.getList(writer, cri);

        int total = productService.getTotal(writer, cri);
        PageVO pageVO = new PageVO(cri, total);


        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);
        System.out.println(pageVO.toString());
        return "product/productList";
    }

    @GetMapping("productReg")
    public String reg() {
        return "product/productReg";
    }


    @GetMapping("productDetail")
    public String detail(@RequestParam("prod_id") int prod_id,
                         Model model) {

        ProductVO vo = productService.getDetail(prod_id);
        model.addAttribute("vo", vo);
        return "product/productDetail";
    }

    // Post방식
    // 등록요청
    @PostMapping("/registForm")
    public String registForm(ProductVO vo, RedirectAttributes ra) {
        int result = productService.productRegist(vo);
        String msg = result == 1 ? "등록 되었습니다." : "등록에 실패하였습니다. 관리자에게 문의하세요.";
        ra.addFlashAttribute("msg", msg);
        return "redirect:/product/productList";
    }

    // post요청
    // 수정요청
    @PostMapping("/modifyForm")
    public String modifyForm(ProductVO vo,
                             RedirectAttributes ra) {

        // 메서드명 = productUpdate()
        // 데이터베이스 업데이트 작업을 진행
        // 업데이트된 결과를 반환 받아서 list화면으로 "업데이트 성공" 메시지를 띄워주세요.

        int result = productService.productUpdate(vo);
        String msg = result == 1 ? "수정되었습니다." : "수정에 실패하였습니다.";
        ra.addFlashAttribute("msg", msg);
        return "redirect:/product/productList";
    }

    // post요청
    // 삭제요청
    @PostMapping("/deleteForm")
    public String deleteForm(ProductVO vo) {
        productService.productDelete(vo.getProd_id());
        return "redirect:/product/productList";
    }

}
