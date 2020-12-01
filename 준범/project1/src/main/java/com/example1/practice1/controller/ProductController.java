package com.example1.practice1.controller;


import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example1.practice1.domain.Pagination;
import com.example1.practice1.domain.ProductDTO;
import com.example1.practice1.service.ProductService;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	// 로깅을 위한 변수
		private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Resource(name = "com.example1.practice1.service.ProductService")
	ProductService productService;	
	
	// 웹 브라우저에서 http://localhost:8088/Product/Productinsert 로 호출한다.
		@RequestMapping("/productinsert")
		private String boardInsertForm() {
			System.out.println("Controller insert......");
			return "/product/productinsert";
		}

		// Controller 에서 Multipart 를 @RequestParet 어노테이션을 통해 별도의 설정없이 사용할 수 있다.
		@RequestMapping("/insertProc")
		private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile productimagefile) throws Exception {

			// 게시글 등록 화면에서 입력한 값들을 실어나르기 위해 BoardVO를 생성한다.
			ProductDTO product = new ProductDTO();
			
			product.setProductname(request.getParameter("productname"));
			product.setProductprice(Integer.parseInt(request.getParameter("productprice")));
			product.setProductsalescnt(Integer.parseInt(request.getParameter("productsalescnt")));
			
			
			if (productimagefile.isEmpty()) { // 업로드할 파일이 없는 경우
				productService.productInsertService(product); // 게시글만 올린다.
			} else { // 업로드할 파일이 있는 경우
				// FilenameUtils : commons-io defendency를 사용.
				String Productimagefile = productimagefile.getOriginalFilename();
				String ProductimageOriName = productimagefile.getOriginalFilename();
				String fileNameExtension = FilenameUtils.getExtension(ProductimageOriName).toLowerCase();
				File destinationFile;
				String destinationFileName;
				// fileUrl = "uploadFiles 폴더의 위치";
				// uploadFiles 폴더의 위치 확인 : uploadFiles 우클릭 -> Properties -> Resource - >
				// Location
				String productimageUrl = "C:\\Users\\TJ\\Desktop\\shoppingproject2\\src\\main\\resources\\static\\upload\\";
				                          
				do {
					destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
					destinationFile = new File(productimageUrl + destinationFileName);
				} while (destinationFile.exists());

				// MultipartFile.transferTo() : 요청 시점의 임시 파일을 로컬 파일 시스템에 영구적으로 복사해준다.
				destinationFile.getParentFile().mkdirs();
				productimagefile.transferTo(destinationFile);

				//productService.productInsertService(product); // 게시글 올리기

				// 파일관련 자료를 Files 테이블에 등록한다.
				product.setProductno(product.getProductno());
				product.setProductimagefile(Productimagefile);
				product.setProductimageName(destinationFileName);
				product.setProductimageOriName(ProductimageOriName);
				product.setProductimageUrl(productimageUrl);

				
				System.out.println("Product Controller product : " + product);
				productService.productInsertService(product);
			}

			return "redirect:/product/productlist";
		}
		
		// 게시글 목록 보여주기
		@RequestMapping(value = "/productlist", method = RequestMethod.GET)
		private String boardList(Model model, @RequestParam(required = false, defaultValue = "1") int page,
				@RequestParam(required = false, defaultValue = "1") int range) throws Exception {

			// 전체 게시글 개수
			int listCnt = productService.getProductListCnt();

			// Pagination 객체생성
			Pagination pagination = new Pagination();

			pagination.pageInfo(page, range, listCnt);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("list", productService.productListService(pagination));
			
			return "/product/productlist";
		}
		// 게시글 번호에 해당하는 상세정보화면
			@RequestMapping("/productdetail/{productno}")
			private String boardDetail(@PathVariable int productno, Model model) throws Exception {
				// bno에 해당하는 자료를 찾아와서 model에 담는다.
				model.addAttribute("productdetail", productService.productDetailService(productno)); // 게시글의 정보를 가져와서 저장한다.					//model.addAttribute("files", productService.fileDetailService(bno)); // 파일의 정보를 가져와서 저장한다.
					return "/product/productdetail";
			}
			
			// 게시글 수정 화면
			@RequestMapping(value = "/Update/{productno}", method = RequestMethod.GET)
			private String getUpdate(@PathVariable int productno, Model model) throws Exception {
				logger.info("update get.....");
				model.addAttribute("productdetail", productService.productDetailService(productno));
				
				return "/product/Update";
			}// end - public String getUpdate(@PathVariable int bno,Model model) throws
				// Exception

			// 게시글 수정 화면에서 수정할 자료를 업데이트한다.
			@RequestMapping("/updateProc")
			private String productUpdateProc(HttpServletRequest request) throws Exception {

				logger.info("updateproc get........");
				ProductDTO productDTO  = new ProductDTO();
				
				productDTO.setProductname(request.getParameter("productname"));
				productDTO.setProductprice(Integer.parseInt(request.getParameter("productprice")));
				productDTO.setProductsalescnt(Integer.parseInt(request.getParameter("productsalescnt")));

				productService.update(productDTO);
				return "redirect:/product/productDetail/" + request.getParameter("productno");
			}
			
			// 글 번호에 해당하는 자료를 삭제한다.
			@RequestMapping("/delete/{productno}")
			private String productDelete(@PathVariable int productno) throws Exception {
				productService.productDeleteService(productno);
				return "redirect:/product/productlist";
			}
}









