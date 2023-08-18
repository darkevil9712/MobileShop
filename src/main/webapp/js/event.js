$(document).ready(function(){
	loadData();
})

function loadData(){
	$.ajax({
        url: 'Product',
        type: 'GET',
        dataType: 'json',
        success: function(result){
			var lstData = result;
			var html = '<div class="row">';
			
			$('#list1').html(''); // clear all data
			// re-draw with new data
			// Arrow Function 2018
			lstData.forEach(item => {
				html += `
					<div class="col-lg-4 col-sm-4">
                              <div class="box_main">
                                 <h4 class="shirt_text">${item.tenSanPham}</h4>
                                 <p class="price_text">Price  <span style="color: #262626;">$ ${formatNumber(item.gia)}</span></p>
                                 <div class="tshirt_img"><img src="${item.hinh}"></div>
                                 <div class="btn_main">
                                    <div class="buy_bt"><a href="#">Buy Now</a></div>
                                    <div class="seemore_bt"><a href="#">See More</a></div>
                                 </div>
                              </div>
                           </div>
				`
			})
			
			html += "</div>"
			$('#list1').html(html); 
		}
 	})
}

function formatNumber(price){
	return new Intl.NumberFormat().format(price);
}