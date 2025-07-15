<!-- createBill.jsp & editBill.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>${bill.id == null ? 'Create New Bill' : 'Edit Bill'}</h2>
<form action="${bill.id == null ? '/bills/save' : '/bills/' + bill.id + '/update'}" method="post">
    <div class="form-group">
        <label>Customer Name</label>
        <input type="text" name="customerName" class="form-control" value="${bill.customerName}" required>
    </div>
    <div class="form-group">
        <label>Date</label>
        <input type="date" name="date" class="form-control" value="${bill.date}" required>
    </div>
    <h4>Items</h4>
    <table class="table" id="itemsTable">
        <thead>
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <select name="billItems[0].item.id" class="form-control">
                    <c:forEach var="item" items="${items}">
                        <option value="${item.id}">${item.name} (₹${item.price})</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="number" name="billItems[0].quantity" class="form-control" value="1" required></td>
            <td><button type="button" class="btn btn-danger btn-sm" onclick="removeRow(this)">Remove</button></td>
        </tr>
        </tbody>
    </table>
    <button type="button" class="btn btn-secondary" onclick="addRow()">Add Item</button>
    <button type="submit" class="btn btn-success">${bill.id == null ? 'Create Bill' : 'Update Bill'}</button>
</form>

<div id="itemSelectTemplate" style="display:none;">
    <select name="billItems[__index__].item.id" class="form-control">
        <c:forEach var="item" items="${items}">
            <option value="${item.id}">${item.name} (₹${item.price})</option>
        </c:forEach>
    </select>
</div>

<script>
function addRow() {
    let table = document.getElementById('itemsTable').getElementsByTagName('tbody')[0];
    let rowCount = table.rows.length;
    let row = table.insertRow(rowCount);
    row.innerHTML = `
        <td>
            <select name="billItems[${rowCount}].item.id" class="form-control">
                ${document.querySelector('select').innerHTML}
            </select>
        </td>
        <td><input type="number" name="billItems[${rowCount}].quantity" class="form-control" value="1" required></td>
        <td><button type="button" class="btn btn-danger btn-sm" onclick="removeRow(this)">Remove</button></td>
    `;
}
function removeRow(button) {
    let row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}
</script>