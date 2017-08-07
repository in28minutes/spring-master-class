<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="col-sm-9 col-md-9">
            <div class="well">
                <div class="page-header">
                    <h1>Create a new todo</h1>
                </div>

                <form:form id="createTodoForm" action="/user/todos/new" method="post" class="form-horizontal" modelAttribute="todo">

                    <fieldset>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="title">Title:</label>
                            <div class="col-sm-10">
                                <form:input type="text" id="title" path="title" required="required" autofocus="autofocus" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="dueDate">Due date:</label>
                            <div class="col-sm-10">
                                <form:input type="text" id="dueDate" path="dueDate" value="${today}" required="required" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="priority">Priority:</label>
                            <div class="col-sm-10">
                                <form:select id="priority" path="priority">
                                  <form:option value="LOW">Low</form:option>
                                  <form:option value="MEDIUM">Medium</form:option>
                                  <form:option value="HIGH">High</form:option>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-actions col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Create</button>
                            <button type="button" class="btn btn-danger" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>

                    <script>
                        $('#dueDate').datepicker({
                            format : 'dd/mm/yyyy'
                        });
                    </script>

                </form:form>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
