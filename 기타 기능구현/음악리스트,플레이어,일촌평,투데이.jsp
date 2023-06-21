
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

  <style>
    .pagination {
      life-style: none;
      width: 100%;
      display: inline-block;
    }
    li{
      list-style: none;
    }

    .pagination-btn {
      float: left;
      margin-left: 5px;
    }
  </style>

</head>
<body>
hahahaha
https://drive.google.com/file/d/1vymAe2hZJaR9ur9_v2evZzg-AhLe7wGH/view?usp=drive_link

https://drive.google.com/file/d/158v03TRUrC9oZWwgenTRNWh_FO8i_QJg/view?usp=drive_link

https://drive.google.com/file/d/1tOOTz-BfhClhYnp7QqxL6IXmRxUP0svE/view?usp=drive_link


<ul class="music">듣고싶은 노래를 고르시오
  <p></p>
  <li class="sun">1. 태양 - 눈코입</li>
  <li class="gd">2. G Dragon - 삐딱하게</li>
  <li class="top">3. 탑 - 무제</li>
  <li class="mine">4. 듣고싶은노래<form>
    <input id="mymusic">

  <button type="submit" id="musicreg" >제출</button>
  </form></li>

</ul>

<audio controls  class="haha">
  <source src="" type='audio/mp3' />
</audio>

<form action="/joker.do" method="post">
<label for="ilchon"> 일촌평을 입력하세요
  <input type="text" name="ilchoncontent" id="ilchon"></label>
  <button  type="submit">등록</button>
</form>
<c:forEach items="${ilchonlist}" var="ilchon">


  <p><span style="color: red">${ilchon.boardNO}번째 일촌평=></span>   ${ilchon.ilchoncontent}</p>





</c:forEach>
<p>오늘의 조회수 : <span style="color: orange">${cnt}</span></p>
</body>
<script>

  // let sunmusic = '1vymAe2hZJaR9ur9_v2evZzg-AhLe7wGH'
  let sunmusic = './js/sun.mp3'
  let gdmusic = '158v03TRUrC9oZWwgenTRNWh_FO8i_QJg'
  let topmusic = '1tOOTz-BfhClhYnp7QqxL6IXmRxUP0svE'
  let mymusic = ''
// $(".sun").on("click",()=>{
//  $(".music >li").attr("style","color:black");
//  $(".sun").attr("style","color:blue");
//   $("audio.haha > source").attr("src", "https://docs.google.com/uc?export=open&id=" + sunmusic);
//   $("audio.haha")[0].load();
// });

  $(".sun").on("click",()=>{
    $(".music >li").attr("style","color:black");
    $(".sun").attr("style","color:blue");
    $("audio.haha > source").attr("src", sunmusic);
    $("audio.haha")[0].load();
  });


  $(".gd").on("click",()=>{
    $(".music >li").attr("style","color:black");
    $(".gd").attr("style","color:blue");

    $("audio.haha > source").attr("src", "https://docs.google.com/uc?export=open&id=" + gdmusic);
    $("audio.haha")[0].load();
  });
  $(".top").on("click",()=>{
    $(".music >li").attr("style","color:black");
    $(".top").attr("style","color:blue");

    $("audio.haha > source").attr("src", "https://docs.google.com/uc?export=open&id=" + topmusic);
    $("audio.haha")[0].load();
  });

  $(".top").on("click",()=>{
    $(".music >li").attr("style","color:black");
    $(".top").attr("style","color:blue");

    $("audio.haha > source").attr("src", "https://docs.google.com/uc?export=open&id=" + topmusic);
    $("audio.haha")[0].load();
  });

  $("#musicreg").on("click",(e)=>{
    e.preventDefault();
    $(".music >li").attr("style","color:black");
    $(".mine").attr("style","color:blue");

    $("audio.haha > source").attr("src", "https://docs.google.com/uc?export=open&id=" + $("#mymusic").val());
    console.log($("#musicreg").val());
    $("audio.haha")[0].load();
  });
</script>
</html>