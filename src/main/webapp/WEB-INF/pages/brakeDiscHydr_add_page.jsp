<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New brakeDiscHydr</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/brakeDiscHydr/add" method="post">
        <h3>New brakeDiscHydr</h3>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${brakeMakers}" var="brakeMaker">
                <option value="${brakeMaker.id}">${brakeMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="name" placeholder="Назва">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="location">
            <option value="-1">Розташування</option>
            <c:forEach items="${locations}" var="location">
                <option value="${location.id}">${location.local}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeLiquid">
            <option value="-1">Гальмівна рідина</option>
            <c:forEach items="${brakeLiquids}" var="brakeLiquid">
                <option value="${brakeLiquid.id}">${brakeLiquid.liq}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="materialHandle" placeholder="Матеріал ручки">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="lengthHydroline">
            <option value="-1">Довжина гідролінії</option>
            <c:forEach items="${lengthHydrolines}" var="lengthHydroline">
                <option value="${lengthHydroline.id}">${lengthHydroline.length}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="rotorDiam">
            <option value="-1">Діаметр ротора</option>
            <c:forEach items="${rotorDiams}" var="rotorDiam">
                <option value="${rotorDiam.id}">${rotorDiam.diam}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="rotorWeight" placeholder="Вага ротора">
        <br>
        <input class="form-control " type="text" name="material" placeholder="Матеріал гальм">
        <br>
        <input class="form-control " type="text" name="brakeWeight" placeholder="Вага гальм">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="rotorFixType">
            <option value="-1">Кріплення ротора</option>
            <c:forEach items="${rotorFixTypes}" var="rotorFixType">
                <option value="${rotorFixType.id}">${rotorFixType.type}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="color" placeholder="Колір">
        <br>
        <input class="form-control " type="text" name="description" placeholder="Опис">
        <br>
        <input class="form-control " type="text" name="price" placeholder="Ціна">
        <br>
        <input class="form-control " type="text" name="way" placeholder="зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>