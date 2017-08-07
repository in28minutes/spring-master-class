<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tl" uri="http://todolist.org/taglib"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../common/header.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-sm-3 col-md-3">
			<%@ include file="../common/sidebar.jspf"%>
		</div>
		<div class="col-sm-9 col-md-9">
			<div class="well">
				<div class="page-header">
					<h1>
						My To Do List <span class="label label-success">${requestScope.doneCount}</span>
						<span class="label label-danger">${requestScope.todoCount}</span>
					</h1>
				</div>

				<table class="table table-bordered table-striped">

					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Due Date</th>
							<th>Priority</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${todoList}" var="currentTodo">
							<tr>
								<td>${currentTodo.id}</td>

								<td>${currentTodo.title}</td>

								<td><fmt:formatDate value="${currentTodo.dueDate}"
										pattern="dd/MM/yyyy" /></td>

								<td><i
									class="icon-circle-arrow-<tl:priorityIcon priority="${currentTodo.priority}"/>"></i>
									${currentTodo.priority}</td>

								<td class="${currentTodo.done?'success':'danger'}"></td>

								<td><a class="btn btn-mini btn-primary"
									href="/user/todos/${currentTodo.id}/update"><i
										class="icon-edit icon-white"></i> Edit</a> <a
									class="btn btn-mini btn-danger" data-toggle="modal"
									href="#confirm_delete_${currentTodo.id}"><i
										class="icon-remove icon-white"></i> Delete</a>
									<div class="modal" id="confirm_delete_${currentTodo.id}">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">×</button>
													<h3>Confirmation</h3>
												</div>
												<div class="modal-body">
													<p>Are you sure to delete todo ${currentTodo.id}
														'${currentTodo.title}' ?</p>
												</div>
												<div class="modal-footer">
													<form action="/user/todos/${currentTodo.id}/delete"
														method="post">
														<a href="#" class="btn btn-default" data-dismiss="modal">Cancel</a>
														<button type="submit" class="btn btn-primary">Confirm</button>
													</form>
												</div>
											</div>
										</div>
									</div></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<c:if test="${empty requestScope.todoList}">
					<div class="alert alert-info">
						<div align="center">Your todo list is empty !</div>
					</div>
				</c:if>

				<div align="center">
					<a class="btn btn-success" href="/user/todos/new"> New To Do </a>
					<button class="btn btn-success" onclick="javascript:window.print()">Print</button>
				</div>

			</div>
		</div>
	</div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>