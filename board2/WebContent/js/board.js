/**
 * 
 */
updateReply = function(){
	$.ajax({
		url: '/board/UpdateReply.do',
		type: 'post',
		data : reply, //reply객체에 cont, renum 이 저장
		dataType : 'json', 
	success : function(){
		alert(res.sw);
	},error: function(xhr){
		alert("상태 " + xhr.status);
	}
	
	})
	
}
//열려있는 수정폼 닫기
replyReset = function() {
	$('#modifyForm').parents('.rep').find('#rmodi').prop('disabled', false);
	spancont = $('#modifyForm').parent(); //span태그 - 댓글 내용
	
	// 원래 내용을 가져와서 수정폼에 출력하기 위해서 
	// br태그를 \n으로 바꾼적이 있는것을 다시 span태그로 출력하기 위해서 \n을 br태그로 바꾼다.
	modifycont = modifycont.replace(/\n/g, "<br>");
	
	$(spancont).append(modifycont); //원래span에 있었던 글내용
	
	//수정폼을 다시 body로 append - 잘라서 붙여넣기 한다.
	$('body').append($('#modifyForm'));
	$('#modifyForm').hide();
}

deleteReply = function(but){
	$.ajax({
		url: '/board/DeleteReply.do',
		type: 'get',
		data : {"renum" : vidx},
		dataType: "json",
		success: function(res){
//			alert(res.sw);
			$(but).parents('.rep').remove();
		},
		error: function(xhr){
			alert(xhr.status);
		}
		
	})
}

replySaveServer = function(but){
	$.ajax({
		url: '/board/InsertReply.do',
		type: 'post',
		data : board, //board객체 - bonum, name, cont
		dataType: 'json',
		success: function(res){
//			alert(res.sw);
			replyListServer(but);
			console.log(but);
		},
		error : function(xhr){
			alert("상태: " + xhr.status);
		}
		
		
		
	})
}


replyListServer = function(but) {
   $.ajax({
      url : "/board/ListReply.do",
      type: "get",
      data : {"bonum" : vidx},
      dataType : 'json',
      success : function(res) {
         //alert("성공");
         recode = "";
         $.each(res, function(i, v) {
            recode += '<div class="panel-body rep">';
            recode += '<p class="p1">';
            recode += v.name+ ' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
            recode += v.redate+ ' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
            recode += "<br><br><span class='cont'>"+ v.cont + "</span>";
            recode += '</p>';
            recode += '<p class="p2">';
            recode += '<button id="rmodi" idx="'+ v.renum +'" type="button" name="r_modify" class="action">댓글수정</button>';
            recode += '<button id="rcl" idx="'+ v.renum +'" type="button" name="r_delete" class="action">댓글삭제</button>';
            recode += '</p>';
            recode += '</div>';
         });
         $(but).parents(".panel").find(".rep").remove();
         $(but).parents(".panel").find(".pbody").append(recode);
      },
      error : function(xhr) {
         alert("상태 : " + xhr.status);
      }
   });
};

readHitServer = function(list){
	$.ajax({
		url: '/board/updateHit.do',
		data: {"num" : vidx},/*$(this).Attr("idx")*/
		dataType: 'json',
		method: 'get',
		success: function(res){
//			alert(res.sw);
			parent = $(list).parents(".panel");
			hit = parseInt($(parent).find('.wh').text());
			
			$(parent).find(".wh").text(++hit);
		},
		error: function(xhr){
			alert(xhr.status);
		}
		
		
		
		
	})
}

updateBoard = function(){
	$.ajax({
		url : '/board/UpdateBoard.do',
		data : $('#mform').serializeJSON(), //name이 컬럼과 일치해야한다.
		method : 'post',
		dataType : 'json',
		success : function(res){
			/*alert(res.sw)*/
			
			//화면에서 수정한 값 출력
			/*parent = $(btn).parents('.panel');*/
			$(parent).find('a').text($('#mform #subject').val());
			$(parent).find('.wm').text($('#mform #mail').val());
			/*$(parent).find('.wr').text($('#mform #writer').val());*/
			// 내용
			cont = $('#mform #content').val();
			cont =  cont.replace(/\r/g, "").replace(/\n/g,"<br>");
			$(parent).find('.wc').html(cont);
			
			
			
			
			$('#modiModal').modal("hide");
			$('#mform.txt').val("");
			
		},
		error: function(xhr){
			alert("상태  : " + xhr.status);
		}
	})
}

deleteBoard = function(btn){
	$.get(
			'/board/DeleteBoard.do',
			{ "num" : vidx},
			function(res){
				/*alert(res.sw);
				$(btn).parents('.panel').remove();*/
				readPageServer(currentPage);
			},
			'json'
		)
};

insertBoard = function(){
	$.post(
			'/board/Insert.do',
			$('#wform').serializeJSON(),
			function(res){
				/*alert(res.sw);*/
				$('#writeModal').modal('hide'); /*모달 닫기*/
				$('.text').val(""); /*모달 내용 지우기*/ 
				readPageServer(1);
			},
			'json'
			)
}


readPageServer = function(cpage){
	$.ajax({
		url: '/board/List.do',
		type: 'post',
		data: {'cpage': cpage},
		success: function(res){
			code = '<div class="panel-group" id="accordion" >';/*id="accordion"*/
			$.each(res.datas, function(i, v) {
	            code += '<div class="panel panel-default">';
	            code += '<div class="panel-heading">';
	            code += '<h4 class="panel-title">';
	            code += '<a idx="' +v.num +'"name="list" class="action" data-toggle="collapse" data-parent="#accordion" href="#collapse' +
	            v.num + '">' + v.subject + '</a>';
	            code += '</h4>';
	            code += '</div>';
	            code += '<div id="collapse' + v.num + '" class="panel-collapse collapse">';
	            code += '<div class="panel-body pbody">';
	            code += '<p class="p1">';
	            code += '작성자 : <span class="wr">' + v.writer + '</span>';
	            code += '이메일 : <span class="wm">' + v.mail + '</span>';
	            code += '작성일 : <span class="wd">' + v.wdate + '</span>';
	            code += '조회수 : <span class="wh">' + v.hit + '</span>';
	            code += '</p>';
	            code += '<p class="p2">';
	            code += '<button idx="' + v.num + '" type="button" name="modify" class="action">수정</button>';
	            code += '<button idx="' + v.num + '" type="button" name="delete" class="action">삭제</button>';
	            code += '</p>';
	            code += '<p class="p3">';
	            code += '<span class="wc">' + v.content + '</span>';
	            code += '</p>';
	            code += '<p class="p4">';
	            code += '<textarea rows="" cols="60"></textarea>';
	            code += '<button idx="' + v.num + '" type="button" name="reply" class="action">등록</button>';
	            code += '</p>';
	            code += '</div>';
	            code += '</div>';
	            code += '</div>';
			});
			code+='</div>';
			$(".box").html(code);
			
			//이전 버튼 출력
			pager = '';
				if(res.startPage>1){
					pager+='<ul class="pul pager">';
					pager += '<li><a class="prev" href="#">Previous</a></li>';
					pager += '</ul>';
				}
			//페이지 번호 출력
				currentPage = cpage;
				pager +='<ul class="pagination">';
				for(i = res.startPage; i<=res.endPage; i++){
					
					if(currentPage==i){
						pager+= '<li class="active"><a class = "paging" href="#">' + i + '</a></li>';
					}else{
						pager+= '<li><a class = "paging" href="#">' + i + '</a></li>';
					};
				}
				pager += '</ul>';
			
			//다음 버튼 출력
				if(res.endPage < res.totalPage){
					pager += '<ul class="pul pager">';
					pager += '<li><a class="next" href="#">Next</a></li>';
				}
				pager+='</ul>';
			$("#pagelist").html(pager);
			
		},
		error: function(xhr){
			alert("상태: " + xhr.status);
		},
		dataType: 'json'
	});
}


readServer = function(){
	$.ajax({
		url:'/board/List.do',
		type: 'get',
		success : function(res){
			code = '<div class="panel-group" id="according>';
			$.each(res, function(i, v) {
	            code += '<div class="panel panel-default">';
	            code += '<div class="panel-heading">';
	            code += '<h4 class="panel-title">';
	            code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse' +
	            v.num + '">' + v.subject + '</a>';
	            code += '</h4>';
	            code += '</div>';
	            code += '<div id="collapse' + v.num + '" class="panel-collapse collapse">';
	            code += '<div class="panel-body">';
	            code += '<p class="p1">';
	            code += '작성자 : ' + v.writer;
	            code += '이메일 : ' + v.mail;
	            code += '작성일 : ' + v.wdate;
	            code += '조회수 : ' + v.hit;
	            code += '</p>';
	            code += '<p class="p2">';
	            code += '<button type="button" name="modify" class="action">수정</button>';
	            code += '<button type="button" name="delete" class="action">삭제</button>';
	            code += '</p>';
	            code += '<p class="p3">';
	            code += v.content;
	            code += '</p>';
	            code += '<p class="p4">';
	            code += '<textarea rows="" cols="60"></textarea>';
	            code += '<button type="button" name="reply" class="action">등록</button>';
	            code += '</p>';
	            code += '</div>';
	            code += '</div>';
	            code += '</div>';
	         });
			code+='</div>';
			$(".box").html(code);
			
		},
		error : function(xhr){
			alert("상태: " + xhr.status);
		},
		dataType: 'json'
	
	});
	
}