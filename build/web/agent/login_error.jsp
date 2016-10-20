<%-- 
    Document   : login
    Created on : 18-Dec-2015, 14:02:00
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title>Login</title>
<jsp:include page="/includes/header.jsp" />

<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
          <div class="pad2">
            <h2 class="pad_bot1 pad_top1">Please enter your username and password to continue.</h2>
            <p>You did not log in successfully.</p>
            <p>Please check your username and password and try again.</p>
<!--            <form id="ContactForm" action="#">-->
                <form action="j_security_check" method="get">
              <div>
                <div  class="wrapper"> <span><br>Username:&nbsp;&nbsp;&nbsp;</span>
                  <input type="text" name="j_username" class="input">
                </div>
                <div  class="wrapper"> <span><br>Password:&nbsp;&nbsp;&nbsp;</span>
                    <input type="password" name="j_password" class="input"><br>
                </div>
                  <span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="submit" value="Login" class="button"></div>
            </form>
          </div>
    
        </article>
        <article class="col2">
          <form id="form_1" action="#" method="post">
            <div class="pad1">
                
              <h3>Agents Profile</h3>
              <p>Please Login to Gain Access.</p>
            <!--
              <div class="row_select"> Search Area:<br>
                <select>
                  <option>&nbsp;</option>
                  <option>...</option>
                  <option>...</option>
                </select>
              </div>
              <div class="row_select">
                <div class="cols"> Price Range:<br>
                  <select>
                    <option>&nbsp;</option>
                    <option>...</option>
                    <option>...</option>
                  </select>
                </div>
                <div class="cols pad_left1"> to:<br>
                  <select>
                    <option>&nbsp;</option>
                    <option>...</option>
                    <option>...</option>
                  </select>
                </div>
              </div>
              <div class="row_select">
                <div class="cols"> Bedroom(s):<br>
                  <select>
                    <option>&nbsp;</option>
                    <option>...</option>
                    <option>...</option>
                  </select>
                </div>
                <div class="cols pad_left1"> Bathroom(s):<br>
                  <select>
                    <option>&nbsp;</option>
                    <option>...</option>
                    <option>...</option>
                  </select>
                </div>
              </div>
              <div class="row_select pad_bot1">
                <div class="cols"> Radius:<br>
                  <select>
                    <option>&nbsp;</option>
                    <option>...</option>
                    <option>...</option>
                  </select>
                </div>
                <div class="cols pad_left1"> <a href="#" class="button">Proposals</a> </div>
              </div>
              Know exactly what you want? <br>
              Try our <a href="#">Advanced Search</a> -->
              
            </div>
          </form>
        </article>
      </div>
<!--      <div class="wrapper">
        <article class="col1">
          <div class="pad2">
            <h2 class="pad_bot1">Useful Links</h2>
            <p class="pad_bot1"><strong>Integer dui leo, dignissim ut interdum ac, ultricies a risus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Curabitur dignissim nunc sit amet odio pharetra hendrerit. </strong></p>
            <p class="pad_bot2">Nulla justo ante, posuere sed hendrerit et, lacinia ultricies ligula. Integer ac lacus vel massa venenatis suscipit in vel nulla. Donec quis placerat erat. Nam id lectus at lacus ullamcorper viverra. Mauris lacinia rutrum purus quis pretium. Pellentesque in tortor quam. Quisque et risus dolor, in consequat nunc. Vivamus sagittis consectetur nisi eget luctus. Maecenas pellentesque placerat dui in iaculis.</p>
          </div>
          <div class="pad_left1">
            <div class="wrapper pad_bot3">
              <article class="cols">
                <ul class="list2">
                  <li><a href="#">Maecenas mattis venenatis</a></li>
                  <li><a href="#">Nam accumsan miac</a></li>
                  <li><a href="#">Rhoncus luctus erat nisl</a></li>
                  <li><a href="#">Ultrices neque, vel placerat</a></li>
                  <li><a href="#">Morbi ut augue ut risus</a></li>
                </ul>
              </article>
              <article class="cols pad_left1">
                <ul class="list2">
                  <li><a href="#">Quisque eget erat eget</a></li>
                  <li><a href="#">Laoreet pharetra eget sed</a></li>
                  <li><a href="#">Vestibulum scelerisque</a></li>
                  <li><a href="#">Integerros massa viverra quis</a></li>
                  <li><a href="#">Pharetra ultrices mauris </a></li>
                </ul>
              </article>
              <article class="cols pad_left1">
                <ul class="list2">
                  <li><a href="#">Phasellus purus sapien</a></li>
                  <li><a href="#">Adipiscing et tempus eget</a></li>
                  <li><a href="#">Faucibus vel leo pellentesque</a></li>
                  <li><a href="#">Ullamcorper ac dignissim</a></li>
                  <li><a href="#">Malesuada eget augue</a></li>
                </ul>
              </article>
            </div>
          </div>
          <div class="pad2"> <a href="#" class="button">Read more</a> </div>
        </article>
        <article class="col2">
          <div class="pad1">
            <h3>Our Contacts</h3>
            <div class="address"> 8901 Marmora Road,<br>
              Glasgow, D04 89GR.<br>
              <span> Freephone:<br>
              Telephone:<br>
              E-mail: </span> +1 800 559 6580<br>
              +1 959 603 6035<br>
              <a href="#">mail@demolink.org</a> </div>
            <h3 class="pad_top1">Miscellaneous Info</h3>
            <p>Lorem ipsum dolor sit amet, consecte- tur adipiscing elit. Fusce condimentum ante velit, vel pharetra ipsum. Nulla mi velit, accumsan dictum mattis sed, dictum id nunc. Nullam varius cursus</p>
            <a href="#" class="button">Read more</a> </div>
        </article>
      </div>-->
    </section>
  </div>
</div>
<!-- / content -->
<jsp:include page="/includes/footer.jsp" />

</body>
</html>
