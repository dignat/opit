<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'huraga-red.css')}" type="text/css">

		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'pictogram-button.css')}" type="text/css">
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.10.3.custom.css')}" type="text/css">

			<script src="${resource(dir:'js',file:'jquery-1.7.1.min.js')}" /></script>
			<script src="${resource(dir:'js',file:'jquery-ui-1.10.3.custom.min.js')}" /></script>
			<script src="${resource(dir:'js',file:'moment.min.js')}" /></script>
			
			
			<script src="${resource(dir:'js',file:'jquery.slimscroll.js')}" /></script>
			
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		
		<script type = "text/javascript">
		;(function($, window, document, undefined) {
  $.fn.responsiveTables = function() {

    // counts total number of td in a head so that we can can use it for label extraction
    var head_col_count = $('thead th').size();

    // only do this if we have something to work with
    if ($(head_col_count).length) {
    // returns the jQuery object to allow for chainability.  
      return this.each(function() {
        var $element = $(this);
        // if we have a th or td in the table then loop over each
        for (i = 0; i <= head_col_count; i++) {
          // head column label extraction
          var head_col_label = $element.find($('thead th:nth-child(' + i + ')')).text();          
          $element.find($('tr td:nth-child(' + i + ')')).attr("data-label", head_col_label);
        };
      });
    };
  };
})(jQuery, window, document);

$('table').responsiveTables();
		</script>





	

		<div id="wrapper">
			
            <div id="header" class ="container">

            	<div id = "companyselect">	<g:render template="/companySelect" /></div>

            	<div id ="Logo"><a href="${createLinkTo(dir:"")}"><img src="${resource(dir: 'images', file: 'cloudcentre-logo.png')}" alt="Calligo"/><g:if test="${controllerName !='login'}">
<div class="but"><g:link controller="logout"><input type="button" value="Logout" class="small button white"/></g:link></div>
</g:if></div></a>


	</div>
		
		
		


<section class = "container" role="main">

			

		<g:layoutBody/>
	</section>
		   </div>
		</div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<g:javascript>
			
		</g:javascript>
		<script>
			$(document).ready(function() {
			
				$('#slimScroll1').slimScroll({
					height: '250px'
				});

			});
		</script>
		<r:layoutResources />


	
		
		
		
	</body>

	
</html>