  <!-- header.jsp (Reusable navigation) -->
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>Hotel Billing System</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="/bills">Hotel Billing</a>
      <div class="collapse navbar-collapse">
          <ul class="navbar-nav">
              <li class="nav-item"><a class="nav-link" href="/home">Home</a></li>
              <li class="nav-item"><a class="nav-link" href="/bills">Bills</a></li>
              <li class="nav-item"><a class="nav-link" href="/bills/new">Create Bill</a></li>
              <li class="nav-item"><a class="nav-link" href="/items">Items</a></li>
          </ul>
      </div>
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
      </ul>
  </nav>
  <div class="container mt-4">