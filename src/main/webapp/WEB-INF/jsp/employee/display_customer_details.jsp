<%-- <!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="employee/headtags.jsp" />
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="emp-login-process" method="POST">
              <h1>Login Form</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="required" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="required" />
              </div>
              <div>
                <button type="submit" class="btn btn-default submit">Log in</button>
                <a class="reset_pass" href="#">Lost your password?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> DBS College</h1>
                  <p>©2016 All Rights Reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="#">Submit</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> DBS College</h1>
                  <p>©2016 All Rights Reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
 --%>
 
 <%@page import="com.cms.model.user.User"%>
<% User user = request.getAttribute("USER_OBJ")!=null ? (User)request.getAttribute("USER_OBJ"):null;%>
 
 
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Registered Successfully</title>
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
   <link rel="stylesheet" href="/static/user/css/jquery-ui.min.css">
  
</head>
    <jsp:include page="headtags.jsp" />



<body>
  <div class="form ">
      
      <div class="">
        <div id="signup">   
          <h1>User Detail's</h1>
          <form action="/save-user" method="POST">
          
           <div class="top-row">
            <div class="field-wrap">
              <label>Name</label>
            </div>
        
            <div class="field-wrap">
	              <label>
	              <%=user!=null ? user.getFirstName():"null" %>
	              </label>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Email Address<span class="req"> </span>
            </label>
            <input type="email" name="email" autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Age<span class="req"> </span>
            </label>
            <input type="text" name="age" autocomplete="off"/>
          </div>
          
            <div class="field-wrap">
            <label>
              User Name<span class="req"> </span>
            </label>
            <input type="text" name ="user_name" autocomplete="off"/>
          </div> 
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req"> </span>
            </label>
            <input type="password"required name ="password" autocomplete="off"/>
          </div> 
          
          <button type="submit" class="button button-block"/>Get Started</button>
          
          </form>

        </div>
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>
    
   <!--  <script type="text/javascript">
    $('.form').find('input, textarea').on('keyup blur focus', function (e) {
    	  
    	  var $this = $(this),
    	      label = $this.prev('label');

    		  if (e.type === 'keyup') {
    				if ($this.val() === '') {
    	          label.removeClass('active highlight');
    	        } else {
    	          label.addClass('active highlight');
    	        }
    	    } else if (e.type === 'blur') {
    	    	if( $this.val() === '' ) {
    	    		label.removeClass('active highlight'); 
    				} else {
    			    label.removeClass('highlight');   
    				}   
    	    } else if (e.type === 'focus') {
    	      
    	      if( $this.val() === '' ) {
    	    		label.removeClass('highlight'); 
    				} 
    	      else if( $this.val() !== '' ) {
    			    label.addClass('highlight');
    				}
    	    }

    	});

    	$('.tab a').on('click', function (e) {
    	  
    	  e.preventDefault();
    	  
    	  $(this).parent().addClass('active');
    	  $(this).parent().siblings().removeClass('active');
    	  
    	  target = $(this).attr('href');

    	  $('.tab-content > div').not(target).hide();
    	  
    	  $(target).fadeIn(600);
    	  
    	});
    
    </script> -->

</body>
</html>
 