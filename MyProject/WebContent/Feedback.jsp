<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
</head>
<body>

<form action="F2" method="post">
<table>
        <h1>Sign Up</h1>
        <fieldset>
          <legend><span class="number"> </span>Your basic info</legend>
Name :<input type="text" name="n2"><br>
Username: <input type="text" name ="u2" required="required"><br>
Password: <input type="text" name ="p2" required="required"><br>
Gender: <input type="radio" name="g2" value="Male"> Male
		<input type="radio" name="g2" value="Female"> Female <br>
Language:<input type="checkbox" name ="l2" value="Eng"> Eng
		<input type="checkbox" name ="l2" value="Beng"> Beng
		<input type="checkbox" name ="l2" value="Hindi"> Hindi
		<input type="checkbox" name ="l2" value="Others"> Others<br>
City: <select name="c2">
	<option>Kolkata</option>
	<option>Durgapur</option>
	<option>Delhi</option>
	<option>Hyderabad</option>
</select><br>
</fieldset>
<button type="submit">Submit</button>
        <button type="reset">Reset</button>
        
        </table>
</form>

</body>
</html>