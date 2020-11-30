<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<layoutTag:layout>
	<style>	
.btn {
	 padding: 8px 10px;
	 background-color: #333;
	 color: #f1f1f1;
	 border-radius: 4;
	 transition: .2s;
	 margin-left: 44%;
  }
.carousel-inner img {
    -webkit-filter: grayscale(45%);
    filter: grayscale(45%); /* make all photos black and white */ 
    width: 35%;
    margin: auto;
  }
	.thumbnail {
  	margin-top: 9px;
    font-size: 12px;
    padding: 0 0 15px 0;
    border: 2;
    border-radius: 4;
  }
  .pagination{
  	margin-left: 46%;
  }
 </style>
</head>
<body>

<div class=" text-center">
  <h1 id="fofo">다양한 마이스터</h1>
  <p>각각의 장인들이 올린 작품들을 확인해보세요</p> 
</div>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

<div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="/static/images/프로필1.jpg" alt="모델1" width="1100" height="550">
        <div class="carousel-caption">
          <p>좋은 퀄리티의 제품과 보존도가 좋은 중고 제품들</p>
        </div>      
      </div>
      <div class="item">
        <img src="/static/images/프로필2.jpg" alt="모델4" width="1100" height="550">
        <div class="carousel-caption">
          <p>만들고 다른 사람에게도 자신의 캐릭터를 팔아보자</p>
        </div>      
      </div> 
      <div class="item">
        <img src="/static/images/프로필3.jpg" alt="모델3" width="1100" height="550">
        <div class="carousel-caption">
          <p>그저 팔기만 하지말고 자작 캐릭터의 설정특징을 알리고 팬으로 만들어 보자!</p>
        </div>      
      </div>
    </div>

 <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<c:forEach var="product" items="${list}">
     <div class="col-sm-3">
        <div class="thumbnail">
          <img src="/static/upload/${product.productimageName}" alt="이미지 업로드" >
          <button class="btn" data-toggle="modal" data-target="#myModal">Click</button>
        </div>
      </div>
</c:forEach>   
  
 
  <!-- 클릭시 팝업 창 -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
    
 <!-- Modal 팝업창 세부 내용-->
<div class="modal-content">
     <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span>상세 내용</h4>
       	</div>
    <div class="modal-body">
          <form role="form">
            <div class="form-group">
             <p>고양이 !</p>
             <p>고어로는 '괴'였으리라고 짐작된다. 더 이른 시기에는 '고니 > 고이'. '괴'라는 말에 '작은 것'을 뜻하는 접미사 
             '-앙이'가 붙어서 '괴앙이'가 되었는데, 이 시기의 'ㅚ'는 이중모음 [oj]였기에 뒤 음절 앞에 반모음 [j]의 첨가가 일어나 
             '괴양이'가 되고 다시 '괴'의 끝 [j]가 탈락하여 '고양이'가 되었다는 것이 정설. 즉 [괴앙이 koj.aŋ.i > 괴양이 koj.jaŋ.i > 고양이 ko.jaŋ.i].
              사실상 발음은 '괴(고이)-' 어근 기준으로 고대 이래로 거의 바뀌지 않은 셈이다.</p>
            </div>
   <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> 연락처를 남겨주세요</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
              <button type="submit" class="button btn-block">BUYS 
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
        </div>
  <div class="modal-footer">
          <button type="submit" class="button btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>
          <p>Need <a href="#">help?</a></p>
        </div>
      </div>
    </div>
  </div>

		<!-- pagination{s}
		<div id="paginationBox" >
			<ul class="pagination">
				<c:if test="${productpagination.prev}">

					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_prev('${productpagination.page}', '${productpagination.range}', '${productpagination.rangeSize}')">Previous</a></li>

				</c:if>
				<c:forEach begin="${productpagination.startPage}"
					end="${pagination.endPage}" var="idx">

					<li
						class="page-item <c:out value="${productpagination.page == idx ? 'active' : ''}"/> "><a
						class="page-link" href="#"
						onClick="fn_pagination('${idx}', '${productpagination.range}', '${productpagination.rangeSize}')">
							${idx} </a></li>

				</c:forEach>

				<c:if test="${pagination.next}">

					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_next('${productpagination.range}','${productpagination.range}', '${productpagination.rangeSize}')">Next</a></li>

				</c:if>

			</ul>

		</div>
	 -->
<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>	
	<!-- <script>
		//이전 버튼 이벤트

		function fn_prev(page, range, rangeSize) {

			var page = ((range - 2) * rangeSize) + 1;

			var range = range - 1;

			var url = "${pageContext.request.contextPath}/product/productlist";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}

		//페이지 번호 클릭

		function fn_pagination(page, range, rangeSize, searchType, keyword) {

			var url = "${pageContext.request.contextPath}/product/productlist";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}

		//다음 버튼 이벤트

		function fn_next(page, range, rangeSize) {

			var page = parseInt((range * rangeSize)) + 1;

			var range = parseInt(range) + 1;

			var url = "${pageContext.request.contextPath}/product/productlist";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}
	</script>
-->
</body>
</html>
</layoutTag:layout>

<!-- layoutTag를 적용하므로 bootstrap.jsp 파일이 필요 없어졌다. -->
<%--== : eq
!= : ne
< : lt
> : gt
<= : le
>= : ge --%>


















