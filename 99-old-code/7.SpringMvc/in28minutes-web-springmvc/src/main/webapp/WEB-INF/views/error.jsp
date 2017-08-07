<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jspf"%>
<%--content--%>

<div class="container">
    <div class="row">
        <div class="alert alert-block alert-error fade in">
            <h2 class="alert-heading">An error occurred, please find details below:</h2>
            <p>${error}</p>
            <br/>
            <div align="center">
                <p>
                    <a class="btn btn-danger" href="javascript:history.go(-1);">Back</a>
                </p>
            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="common/footer.jspf"%>
