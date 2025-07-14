<!-- createItem.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>Add New Item</h2>
<form action="/items/save" method="post">
    <div class="form-group">
        <label>Item Name</label>
        <input type="text" name="name" class="form-control" required>
    </div>
    <div class="form-group">
        <label>Price</label>
        <input type="number" name="price" step="0.01" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-success">Add Item</button>
    <a href="/items" class="btn btn-secondary">Cancel</a>
</form>
