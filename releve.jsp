<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
        <%@ page import="java.util.ArrayList ,Model.Etudiant,Model.Note" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relevé de notes</title>
</head>
<body>


<% 

if (request.getSession().getAttribute("etud")==null)
	request.getRequestDispatcher("index.jsp").forward(request, response);
else
{

Etudiant e = (Etudiant) request.getSession(). getAttribute("etud") ; 
ArrayList<Note> notes = (ArrayList<Note>) request.getAttribute("notes") ; 

%>
<div align="justify" style="margin-top: 150px">
Cin : <%= e.getCin()    %><br>
Nom et Prénom :  <%= e.getNom() + " " + e.getPrenom() %><br>
<br>
<br>
<table style="border=1px">
<tr>
<th>Matière</th>
<th>Note Examen</th>
<th>Note TP</th>
<th>Moyenne</th>
</tr>

<% 
float score = 0 ; 
for (Note n : notes){
	score += n.getNoteEx()*0.7 + n.getNoteTp()*0.3 ; 
	%>

<tr>
<td> <%=  n.getMatiere() %>  </td>
<td> <%= n.getNoteEx() %>  </td>
<td> <%= n.getNoteTp() %>  </td>
<td> <%= String.format("%.2f",n.getNoteEx()*0.7 + n.getNoteTp()*0.3) %>  </td>
<td>   </td>
</tr>
<% }  %>
</table>
<h2>Moyenne Générale : <%= String.format("%.2f", score/notes.size())  %></h2>
</div>
<% } %>
</body>
</html>