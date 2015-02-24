<%@ page import="com.github.javamentorship.mentorship.Model" %>
<html>
<head>

    <style type="text/css">
        div.header {
            background-color: #717dc9;
            border: groove;
            width: 420px;
            height: 50px;
            text-align: center;
            text-decoration-style: solid;
            font-size: larger;
            display: table-cell;
            vertical-align: middle;
            font-family: Arial;
        }

        div.memory {
            background-color: #dddddd;
            border: groove;
            width: 300px;
            height: 70px;
            float: left;
            text-align: center;
            font-family: Arial;
        }

        div.pointer {
            background-color: #dddddd;
            border: groove;
            width: 100px;
            height: 70px;
            margin-left: 300px;
            padding-left: 20px;
            text-align: center;
            font-family: Arial;
        }

        div.cmd_pointer {
            background-color: #dddddd;
            border: groove;
            width: 100px;
            height: 100px;
            margin-left: 300px;
            margin-inside: 150px;
            padding-left: 20px;
            text-align: center;
            font-family: Arial;
        }

        div.commands {
            background-color: #dddddd;
            border: groove;
            width: 300px;
            height: 100px;
            float: left;
            margin-inside: 150px;
            text-align: center;
            font-family: Arial;
        }

        div.stack {
            background-color: #dddddd;
            border: groove;
            width: 300px;
            height: 100px;
            float: left;
            margin-inside: 250px;
            text-align: center;
            font-family: Arial;
        }
    </style>
</head>
<body>

<div class="header" id="header">
    BRAINFUCK INTERPRETER
</div>

<div class="memory" id="memory">
    <% out.println(Model.printMemoryTable()); %>
    <br/>
</div>

<div class="pointer" id="pointer">
    POINTER
    <br/>
</div>

<div class="commands" id="commands">
    <% out.println(Model.printCommandTable()); %>
    <br/>
</div>

<div class="cmd_pointer" id="cmd_pointer">
    CMD POINTER
    <br/>
</div>

<div class="stack" id="stack">
    STACK
    <br/>
</div>

</body>
</html>