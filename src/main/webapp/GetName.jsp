<html>
<body>
Hello, <%=session.getAttribute("username")%><br/>
<form METHOD="post" ACTION="SaveName.jsp">
    What's your name? <input TYPE="text" NAME="username" SIZE="20"><BR>
    What's your e-mail address? <input TYPE="text" NAME="email" SIZE="20"><BR>
    What's your age? <input TYPE="text" NAME="age" SIZE="4">

    <P><input TYPE="submit">
</form>
</body>

</html>