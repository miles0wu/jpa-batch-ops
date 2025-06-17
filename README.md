# Batch Insert Demo with Custom Spring Data JPA Repository

This sample project demonstrates how to **extend a Spring Data JPA `JpaRepository`** by adding batch insert (`batchInsert`) and batch query (`findByIdsBatch`) methods via a **custom fragment interface and its `Impl` implementation**, while preserving the default CRUD functionality of the original repository.

---

## Official Reference

I followed the official **[Custom Repository Implementations](https://docs.spring.io/spring-data/jpa/reference/repositories/custom-implementations.html)** pattern described in the Spring Data JPA reference guide:

> “To enrich a repository with custom functionality, you must first define a fragment interface and an implementation for the custom functionality… The most important part of the class name that corresponds to the fragment interface is the `Impl` postfix.”

This pattern includes:

1. Defining a **fragment interface** (`PersonRepositoryCustom`).
2. Creating a class named with the **`Impl` suffix** (`PersonRepositoryCustomImpl`) that implements the interface.
3. Extending both `JpaRepository` and the custom interface in the main repository (`PersonRepository`).

This allows you to add custom, optimized batch methods without interfering with the default repository behavior and aligns with the official design.
