<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transmissions</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>

<body>

<div class="container">

    <h3><img height="200" width="1200" src="<c:url value="/static/panorama.png"/>"/><a href="/"></a></h3>
    <big>Шатуни</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_crank" class="btn btn-default navbar-btn">Додати шатуни</button></li>
                    <li><button type="button" id="add_crankMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_crank" class="btn btn-default navbar-btn">Видалити шатуни</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип велосипеду</b></td>
            <td><b>Сумісність з кількістю передач</b></td>
            <td><b>Кількість зірок</b></td>
            <td><b>Набір зірок</b></td>
            <td><b>Найбільша зірка</b></td>
            <td><b>Найменша зірка</b></td>
            <td><b>Довжина шатуна</b></td>
            <td><b>Матеріал зірок</b></td>
            <td><b>Матеріал шатуна</b></td>
            <td><b>Тип каретки</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${cranks}" var="crank">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${crank.id}" id="checkbox_${crank.id}"/></td>

                <td>${crank.name}</td>

                <c:choose>
                    <c:when test="${crank.bikeType ne null}">
                        <td>${crank.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${crank.backSprocketNumber ne null}">
                        <td>${crank.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${crank.frontSprocketNumber ne null}">
                        <td>${crank.frontSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                <c:when test="${crank.frontSprocketSize ne null}">
                    <td>${crank.frontSprocketSize.size}</td>
                </c:when>
                <c:otherwise>
                    <td>Default</td>
                </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${crank.frontSprocketMax ne null}">
                        <td>${crank.frontSprocketMax.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${crank.frontSprocketMin ne null}">
                        <td>${crank.frontSprocketMin.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${crank.crankLength ne null}">
                        <td>${crank.crankLength.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${crank.sprocketMaterial}</td>
                <td>${crank.crankMaterial}</td>

                <c:choose>
                    <c:when test="${crank.bracketType ne null}">
                        <td>${crank.bracketType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${crank.color}</td>
                <td>${crank.description}</td>
                <td>${crank.price}</td>

                <c:choose>
                    <c:when test="${crank.transmissionMaker ne null}">
                        <td>${crank.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${crank.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Касети</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul id="groupList1" class="nav navbar-nav">
                    <li><button type="button" id="add_backGearKas" class="btn btn-default navbar-btn">Додати касету</button></li>
                    <li><button type="button" id="add_backGearKasMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_backGearKas" class="btn btn-default navbar-btn">Видалити касету</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Кількість зірок</b></td>
            <td><b>Найбільша зірка</b></td>
            <td><b>Найменша зірка</b></td>
            <td><b>Кількість зубів зірок</b></td>
            <td><b>матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${backGearKass}" var="backGearKas">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${backGearKas.id}" id="checkbox_${backGearKas.id}"/></td>

                <td>${backGearKas.name}</td>


                <c:choose>
                    <c:when test="${backGearKas.backSprocketNumber ne null}">
                        <td>${backGearKas.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearKas.backSprocketMax ne null}">
                        <td>${backGearKas.backSprocketMax.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearKas.backSprocketMin ne null}">
                        <td>${backGearKas.backSprocketMin.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearKas.backSprocketSize ne null}">
                        <td>${backGearKas.backSprocketSize.size}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <td>${backGearKas.material}</td>
                <td>${backGearKas.color}</td>
                <td>${backGearKas.description}</td>
                <td>${backGearKas.price}</td>

                <c:choose>
                    <c:when test="${backGearKas.transmissionMaker ne null}">
                        <td>${backGearKas.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${backGearKas.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Трещітка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul id="groupList2" class="nav navbar-nav">
                    <li><button type="button" id="add_backGearTr" class="btn btn-default navbar-btn">Додати трещітку</button></li>
                    <li><button type="button" id="add_backGearTrMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_backGearTr" class="btn btn-default navbar-btn">Видалити трещітку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Кількість зірок</b></td>
            <td><b>Найбільша зірка</b></td>
            <td><b>Найменша зірка</b></td>
            <td><b>Кількість зубів зірок</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${backGearTrs}" var="backGearTr">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${backGearTr.id}" id="checkbox_${backGearTr.id}"/></td>

                <td>${backGearTr.name}</td>


                <c:choose>
                    <c:when test="${backGearTr.backSprocketNumber ne null}">
                        <td>${backGearTr.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearTr.backSprocketMax ne null}">
                        <td>${backGearTr.backSprocketMax.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearTr.backSprocketMin ne null}">
                        <td>${backGearTr.backSprocketMin.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backGearTr.backSprocketSize ne null}">
                        <td>${backGearTr.backSprocketSize.size}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <td>${backGearTr.material}</td>
                <td>${backGearTr.color}</td>
                <td>${backGearTr.description}</td>
                <td>${backGearTr.price}</td>

                <c:choose>
                    <c:when test="${backGearTr.transmissionMaker ne null}">
                        <td>${backGearTr.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${backGearTr.way}"/></td>
            </tr>
        </c:forEach>
    </table>



    <big>Задня перекидка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                <ul id="groupList3" class="nav navbar-nav">
                    <li><button type="button" id="add_backDerailleur" class="btn btn-default navbar-btn">Додати перекидку</button></li>
                    <li><button type="button" id="add_backDerailleurMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_backDerailleur" class="btn btn-default navbar-btn">Видалити перекидку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Сумісність з кількістю передач</b></td>
            <td><b>Найбільша зірка</b></td>
            <td><b>Найменша зірка</b></td>
            <td><b>Довжина лапки</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${backDerailleurs}" var="backDerailleur">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${backDerailleur.id}" id="checkbox_${backDerailleur.id}"/></td>

                <td>${backDerailleur.name}</td>


                <c:choose>
                    <c:when test="${backDerailleur.backSprocketNumber ne null}">
                        <td>${backDerailleur.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backDerailleur.backSprocketMax ne null}">
                        <td>${backDerailleur.backSprocketMax.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backDerailleur.backSprocketMin ne null}">
                        <td>${backDerailleur.backSprocketMin.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backDerailleur.pawLength ne null}">
                        <td>${backDerailleur.pawLength.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${backDerailleur.material}</td>
                <td>${backDerailleur.weight}</td>
                <td>${backDerailleur.color}</td>
                <td>${backDerailleur.description}</td>
                <td>${backDerailleur.price}</td>

                <c:choose>
                    <c:when test="${backDerailleur.transmissionMaker ne null}">
                        <td>${backDerailleur.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${backDerailleur.way}"/></td>
            </tr>
        </c:forEach>
    </table>



    <big>Передня перекидка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
                <ul id="groupList4" class="nav navbar-nav">
                    <li><button type="button" id="add_frontDerailleur" class="btn btn-default navbar-btn">Додати передню перекидку</button></li>
                    <li><button type="button" id="add_frontDerailleurMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_frontDerailleur" class="btn btn-default navbar-btn">Видалити передню перекидку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Сумісність з кількістю передніх зірок</b></td>
            <td><b>Сумісність з кількістю задніх зірок</b></td>
            <td><b>Найбільша зірка</b></td>
            <td><b>Найменша зірка</b></td>
            <td><b>Ємність зубів</b></td>
            <td><b>Лінія ланцюга</b></td>
            <td><b>Тип кріплення</b></td>
            <td><b>Діаметр хомута</b></td>
            <td><b>Тип тяги</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${frontDerailleurs}" var="frontDerailleur">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${frontDerailleur.id}" id="checkbox_${frontDerailleur.id}"/></td>

                <td>${frontDerailleur.name}</td>

                <c:choose>
                    <c:when test="${frontDerailleur.frontSprocketNumber ne null}">
                        <td>${frontDerailleur.frontSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${frontDerailleur.backSprocketNumber ne null}">
                        <td>${frontDerailleur.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${frontDerailleur.frontSprocketMax ne null}">
                        <td>${frontDerailleur.frontSprocketMax.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${frontDerailleur.frontSprocketMin ne null}">
                        <td>${frontDerailleur.frontSprocketMin.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${frontDerailleur.teethCapasity ne null}">
                        <td>${frontDerailleur.teethCapasity.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${frontDerailleur.chainLine}</td>


                <c:choose>
                    <c:when test="${frontDerailleur.frontDerailleurFixType ne null}">
                        <td>${frontDerailleur.frontDerailleurFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${frontDerailleur.collarDiam ne null}">
                        <td>${frontDerailleur.collarDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${frontDerailleur.tractionType ne null}">
                        <td>${frontDerailleur.tractionType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frontDerailleur.material}</td>
                <td>${frontDerailleur.weight}</td>
                <td>${frontDerailleur.color}</td>
                <td>${frontDerailleur.description}</td>
                <td>${frontDerailleur.price}</td>

                <c:choose>
                    <c:when test="${frontDerailleur.transmissionMaker ne null}">
                        <td>${frontDerailleur.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${frontDerailleur.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big>Каретка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
                <ul id="groupList5" class="nav navbar-nav">
                    <li><button type="button" id="add_bracket" class="btn btn-default navbar-btn">Додати каретку</button></li>
                    <li><button type="button" id="add_bracketMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_bracket" class="btn btn-default navbar-btn">Видалити каретки</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Довжина валу</b></td>
            <td><b>Ширина каретки</b></td>
            <td><b>Тип каретки</b></td>
            <td><b>Тип підшипників</b></td>
            <td><b>Матеріал осі</b></td>
            <td><b>Тип різьби</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${brackets}" var="bracket">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${bracket.id}" id="checkbox_${bracker.id}"/></td>

                <td>${bracket.name}</td>

                <c:choose>
                    <c:when test="${bracket.bracketAxisLength ne null}">
                        <td>${bracket.bracketAxisLength.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${bracket.bracketWide ne null}">
                        <td>${bracket.bracketWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${bracket.bracketType ne null}">
                        <td>${bracket.bracketType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${bracket.bearingType ne null}">
                        <td>${bracket.bearingType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${bracket.axisMaterial}</td>

                <c:choose>
                    <c:when test="${bracket.carvingType ne null}">
                        <td>${bracket.carvingType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${bracket.color}</td>
                <td>${bracket.description}</td>
                <td>${bracket.price}</td>

                <c:choose>
                    <c:when test="${bracket.transmissionMaker ne null}">
                        <td>${bracket.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${bracket.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Педалі</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-7">
                <ul id="groupList6" class="nav navbar-nav">
                    <li><button type="button" id="add_pedal" class="btn btn-default navbar-btn">Додати педалі</button></li>
                    <li><button type="button" id="add_pedalMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_pedal" class="btn btn-default navbar-btn">Видалити педалі</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип педалей</b></td>
            <td><b>Тип підшипників</b></td>
            <td><b>Розміри</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${pedals}" var="pedal">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${pedal.id}" id="checkbox_${pedal.id}"/></td>

                <td>${pedal.name}</td>

                <c:choose>
                    <c:when test="${pedal.pedalType ne null}">
                        <td>${pedal.pedalType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${pedal.bearingType ne null}">
                        <td>${pedal.bearingType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${pedal.sizes}</td>
                <td>${pedal.material}</td>
                <td>${pedal.weight}</td>
                <td>${pedal.color}</td>
                <td>${pedal.description}</td>
                <td>${pedal.price}</td>

                <c:choose>
                    <c:when test="${pedal.transmissionMaker ne null}">
                        <td>${pedal.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${pedal.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Ланцюг</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-8">
                <ul id="groupList7" class="nav navbar-nav">
                    <li><button type="button" id="add_chain" class="btn btn-default navbar-btn">Додати ланцюг</button></li>
                    <li><button type="button" id="add_chainMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_chain" class="btn btn-default navbar-btn">Видалити ланцюги</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                                <li><a href="/transmissionMaker/${transmissionMaker.id}">${transmissionMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Сумісність з задніми передачами</b></td>
            <td><b>Кількість ланок</b></td>
            <td><b>Вага</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${chains}" var="chain">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${chain.id}" id="checkbox_${chain.id}"/></td>

                <td>${chain.name}</td>

                <c:choose>
                    <c:when test="${chain.backSprocketNumber ne null}">
                        <td>${chain.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${chain.chainElementNumber ne null}">
                        <td>${chain.chainElementNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${chain.weight}</td>
                <td>${chain.material}</td>
                <td>${chain.color}</td>
                <td>${chain.description}</td>
                <td>${chain.price}</td>

                <c:choose>
                    <c:when test="${chain.transmissionMaker ne null}">
                        <td>${chain.transmissionMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${chain.way}"/></td>
            </tr>
        </c:forEach>
    </table>





    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_transmissions?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/transmissionMaker/${transmissionMakerId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_backGearKas').click(function(){
        window.location.href='/backGearKas_add_page';
    });

    $('#add_backGearTr').click(function(){
        window.location.href='/backGearTr_add_page';
    });
    $('#add_bracket').click(function(){
        window.location.href='/bracket_add_page';
    });
    $('#add_chain').click(function(){
        window.location.href='/chain_add_page';
    });
    $('#add_crank').click(function(){
        window.location.href='/crank_add_page';
    });
    $('#add_frontDerailleur').click(function(){
        window.location.href='/frontDerailleur_add_page';
    });
    $('#add_backDerailleur').click(function(){
        window.location.href='/backDerailleur_add_page';
    });
    $('#add_pedal').click(function(){
        window.location.href='/pedal_add_page';
    });





    $('#add_backGearKasMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_backGearTrMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_backDerailleurMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_chainMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_crankMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_frontDerailleurMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_pedalMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });
    $('#add_bracketMaker').click(function(){
        window.location.href='/transmissionMaker_add_page';
    });



    $('#delete_backGearKas').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/backGearKas/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_backGearTr').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/backGearTr/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_backDerailleur').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/backDerailleur/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_bracket').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/bracket/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_chain').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/chain/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_crank').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/crank/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_frontDerailleur').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/frontDerailleur/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_pedal').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/pedal/delete", data, function(data, status) {
            window.location.reload();
        });
    });



</script>
</body>
</html>