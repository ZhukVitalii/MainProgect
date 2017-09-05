<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New headset</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/headset/add" method="post">
        <h3>New headset</h3>
        <select class="selectpicker form-control form-handlebarMaker" name="handlebarMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                <option value="${handlebarMaker.id}">${handlebarMaker.name}</option>
            </c:forEach>
        </select>
        <input class="form-control form-handlebarMaker" type="text" name="name" placeholder="назва">
        <select class="selectpicker form-control form-handlebarMaker" name="headsetType">
            <option value="-1">Тип</option>
            <c:forEach items="${headsetTypes}" var="headsetType">
                <option value="${headsetType.id}">${headsetType.type}</option>
            </c:forEach>
        </select>
        <select class="selectpicker form-control form-tubeDiameter" name="tubeDiameter">
            <option value="-1">Діаметр штока</option>
            <c:forEach items="${tubeDiameter}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>
        <select class="selectpicker form-control form-handlebarMaker" name="handlebarMaterial">
            <option value="-1">Матеріал</option>
            <c:forEach items="${handlebarMaterial}" var="handlebarMaterial">
                <option value="${handlebarMaterial.id}">${handlebarMaterial.material}</option>
           </c:forEach>
        </select>
        <input class="form-control form-forkMaker" type="text" name="size" placeholder="розмір">
        <input class="form-control form-forkMaker" type="text" name="color" placeholder="колір">
        <input class="form-control form-forkMaker" type="text" name="price" placeholder="ціна">
        <input class="form-control form-forkMaker" type="text" name="description" placeholder="опис ">
        <input class="form-control form-forkMaker" type="text" name="way" placeholder="зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>

</body>
</html>