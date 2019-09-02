/**
 * 
 */
function realSysTime(clock){
	    var now=new Date();
	    var year=now.getFullYear();
	    var month=now.getMonth();
	    var date=now.getDate();
	    var day=now.getDay();
	    var hour=now.getHours();
	    var minu=now.getMinutes();
	    var sec=now.getSeconds();
	    month=month+1;
	    var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	    var week=arr_week[day];
	    var time=year+"年 "+month+"月 "+date+"日 "+week;
	    if(hour<10){
	       time=time+" 0"+hour;
	    }
	    else{
	       time=time+" "+hour;
	    }
	    if(minu<10){
	      time=time+":0"+minu;
	    }
	    else{
	      time=time+":"+minu;
	    }
	    if(sec<10){
	      time=time+":0"+sec;
	    }
	    else{
	      time=time+":"+sec;
	    }
	    
	    clock.innerHTML="当前时间："+time;
	  }
	  window.onload=function(){
	    window.setInterval("realSysTime(clock)", 1000);
	    }
	  $(function(){
  		$(".act1").click(function(e){
  			var $form1=$(".notice");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".u1").click(function(e){
  			var $form1=$(".user1");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".p").click(function(e){
  			var $form1=$(this).parent();
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".u2").click(function(e){
  			var $form1=$(".user2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".u3").click(function(e){
  			var $form1=$(".user3");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".c1").click(function(e){
  			var $form1=$(".car1");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".c2").click(function(e){
  			var $form1=$(".car2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".c3").click(function(e){
  			var $form1=$(".car3");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".w1").click(function(e){
  			var $form1=$(".worker");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".w2").click(function(e){
  			var $form1=$(".worker2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".w3").click(function(e){
  			var $form1=$(".worker3");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".p1").click(function(e){
  			var $form1=$(".parts");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".p2").click(function(e){
  			var $form1=$(".parts2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".p3").click(function(e){
  			var $form1=$(".parts3");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".o1").click(function(e){
  			var $form1=$(".order1");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".o2").click(function(e){
  			var $form1=$(".order2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".o3").click(function(e){
  			var $form1=$(".order3");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".o4").click(function(e){
  			var $form1=$(".order4");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".o5").click(function(e){
  			var $form1=$(".order5");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".a1").click(function(e){
  			var $form1=$(".article1");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".a2").click(function(e){
  			var $form1=$(".article2");
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".next2").click(function(e){
  			var $form1=$(this).next();
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})
  	$(function(){
  		$(".next1").click(function(e){
  			var $form1=$(this).next();
  			if($form1.is(":visible")){
  				$form1.hide();
					e.stopPropagation();
  			}else{
  				$form1.show();
					e.stopPropagation();
  			}
  			
  		})
  	})