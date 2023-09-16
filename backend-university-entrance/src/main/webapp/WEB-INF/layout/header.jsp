<%-- 
    Document   : header
    Created on : Aug 6, 2023, 12:36:13 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />
<style type="text/css">
    :root{
        --offcanvas-width: 270px;
        --topNavbarHeight: 56px;
    }
    .sidebar-nav{
        width: var(--offcanvas-width);
    }
    .tss{
        transition: all 0.3s ease 0s
    }
    .offcanvas{
        transition: all 0.3s ease 0s;
    }
    .sidebar-link{
        display: flex;
        align-items: center;
    }

    .sidebar-link .right-icon{
        display: inline-flex;
        transition: all ease 0.25s;
    }

    .sidebar-link[aria-expanded="true"] .right-icon{
        transform: rotate(180deg);
    }
    @media (min-width:992px){
        body{
            overflow: auto !important;
        }
        .modal-backdrop::before{
            display: none;
        }
        .sidebar-nav{
            transform: none;
            visibility: visible !important;
            top: var(--topNavbarHeight);
            height: calc(100% - var(--topNavbarHeight));
        }
    }
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <button class="navbar-toggler me-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
            <span class="navbar-toggler-icon" data-bs-target="#offcanvasExample"></span>
        </button>
        <a class="navbar-brand fw-bold me-auto" href="/">HaRuTa</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse tss" id="navbarSupportedContent">
            <form class="d-flex ms-auto" action="#">
                <div class="input-group my-3 my-lg-0">
                    <input type="text" class="form-control" type="search" name="kw" placeholder="Search..." aria-label="Search">
                    <button class="btn btn-primary" type="submit" id="search"><i class="bi bi-search"></i></button>
                </div>
            </form>
            <ul class="navbar-nav mb-2 mb-lg-0">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-person-fill"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>




<div class="offcanvas offcanvas-start bg-dark text-white sidebar-nav" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">

    <div class="offcanvas-body p-0">
        <nav class="navbar-dark">
            <ul class="navbar-nav">
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3">
                        CORE
                    </div> 
                </li>
                <li>
                    <a href="#" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-house-heart-fill"></i></span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="my-4">
                    <hr class="dropdown-divider" />
                </li>
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3">
                        Interface
                    </div> 
                </li>
                <li>
                    <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                        <span class="me-2"><i class="bi bi-layout-split"></i></span>
                        <span>Layouts</span>
                        <span class="right-icon ms-auto">
                            <i class="bi bi-chevron-down"></i>
                        </span>
                    </a>
                    <div class="collapse tss" id="collapseExample">
                        <div>
                            <ul class="navbar-nav ps-3">
                                <li>
                                    <a href="#" class="nav-link px-3">
                                        <span class="me-2"><i class="bi bi-layout-split"></i></span>
                                        <span>Nested link</span>
                                    </a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</div>
