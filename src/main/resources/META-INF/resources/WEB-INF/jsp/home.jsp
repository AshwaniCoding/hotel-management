<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>Welcome to Hotel Billing Dashboard</h2>
<p>Use the navigation bar to manage bills and items.</p>

<a href="/bills" class="btn btn-primary">View Bills</a>
<a href="/bills/new" class="btn btn-success">Create New Bill</a>
<a href="/items" class="btn btn-info">Manage Items</a>