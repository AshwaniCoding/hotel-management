<!-- editItem.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>Edit Item</h2>
<form action="/items/${item.id}/update" method="post">
    <div class="form-group">
        <label>Item Name</label>
        <input type="text" name="name" class="form-control" value="${item.name}" required>
    </div>
    <div class="form-group">
        <label>Price</label>
        <input type="number" name="price" step="0.01" class="form-control" value="${item.price}" required>
    </div>
    <button type="submit" class="btn btn-success">Update Item</button>
    <a href="/items" class="btn btn-secondary">Cancel</a>
</form>
