## Huong dan truy cap ung dung

- ### Truy cap truc tiep
    - Truy cap ung dung bang lien ket: `https://todo-list-st8q.onrender.com/`
    - Truy cap truc tiep bang command line: `open -a "google chrome" https://todo-list-st8q.onrender.com/`

> [!IMPORTANT]
> Khi lan dau tien trinh chay tren `https://todo-list-st8q.onrender.com/`, ung dung co the thuc hien tien trinh build.
> Sau khi hoan tat trinh duyet tu dong dieu huong ve trang chu `/` cua ung dung.

- ### Chay ung dung bang Docker
    - Yeu cau thiet bi co Docker Desktop cho Linux/MacOS/Windows
    - Co the tai va cai dat Docker Desktop theo huong dan **[Tai Day](https://www.docker.com/products/docker-desktop/)**
    - Sau khi cai dat thanh cong, thuc hien cac buoc sau de chay ung dung bang Docker Desktop theo cac buoc:

        ````bash
        # Dam bao Docker Engine da duoc khoi dong truoc khi thuc hien Docker command trinh chay ung dung Todo-list
        # Tao moi thu nuc
        $ mkdir -p todo-list && cd todo-list
        
        # Sao chep reo todo-list
        $ git clone https://github.com/quangdai2207/todo_list .
        
        # Trinh chay ung dung bang Compose file
        $ docker compose up -d
      
        # Stop ug dung
        $ docker compose down -v
        ````

  Sau khi thuc hien lenh trinh chay ung dung bang Docker, truy cap vao lien ket de test ung sung
  > 🌏 http://localhost:3000

---

## Tai lieu huong dan

> [!NOTE]
> **LUU Y:**
> Todo-list la ung dung mini voi cac chuc nang CRUD theo mo hinh Web MVC co ban, duoc build tren Spring Framework Java.
> Moi du lieu tren ung dung duoc luu trong bo nho Ram cua may tinh, khong su dung bat ky ket noi co so du lieu nao nhu
> MySql, Postgres...vv
>
> Vi ung dung khong su dung co so du lieu de luu tru du lieu trong qua trinh test ung dung nen khi khi ung dung tat hoac
> khoi dong lai thi toan bo du lieu test truoc do se khong con luu trong bo nho Ram.
>
> Package Repositories la noi khoi tao du lieu ban dau cho toan bo dung dung Todo-list

- #### Cau truc du an gom co:

| **Packages**                                                 | **Explains**                               |
|--------------------------------------------------------------|--------------------------------------------|
| [Controllers](./src/main/java/intern/todolist/controllers)   | Bo dieu khien request tu nguoi dung        |
| [Entities](./src/main/java/intern/todolist/entities)         | package chua lop doi tuong Job             |
| [Repositories](./src/main/java/intern/todolist/repositories) | package chua du lieu va truy van du lieu   |
| [Services](./src/main/java/intern/todolist/services)         | package xu ly logic du lieu cho controller |
| [Resources](./src/main/resources)                            | package chua tai nguyen va file html, css  |










