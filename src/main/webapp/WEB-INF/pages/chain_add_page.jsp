<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New chain</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="/resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/admin/chain/add"
          method="post">
        <h3>Додати ланцюг</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="transmissionMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${transmissionMakers}"
                       var="transmissionMaker">
                <option value="${transmissionMaker.id}">${transmissionMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <div class="numbers">
            <input class="form-control"
                   type="number"
                   name="article"
                   placeholder="Артикул">
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="url"
               placeholder="url">
        <br>
        <input class="form-control"
               type="text"
               name="name"
               placeholder="Назва">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="backSprocketNumber">
            <option value="-1">Сумісність з кількістю передач</option>
            <c:forEach items="${backSprocketNumber}"
                       var="backSprocketNumber">
                <option value="${backSprocketNumber.id}">${backSprocketNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="chainElementNumber">
            <option value="-1">Калькість ланок</option>
            <c:forEach items="${chainElementNumber}"
                       var="chainElementNumber">
                <option value="${chainElementNumber.id}">${chainElementNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="weight"
               placeholder="Вага">
        <br>
        <input class="form-control"
               type="text"
               name="material"
               placeholder="Матеріал">
        <br>
        <input class="form-control"
               type="text"
               name="color"
               placeholder="Колір">
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="Опис">
        <br>
        <div class="numbers">
            <input class="form-control"
                   type="number"
                   name="price"
                   placeholder="ціна">
            <div class="number-error">Доступний тільки ввід числових значень</div>
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="way"
               placeholder="зображення">
        <br>
        <input type="submit"
               class="btn btn-primary"
               value="Add">
    </form>
</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>