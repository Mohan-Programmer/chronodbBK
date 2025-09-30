    package chronodb.chrono.models;

    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Entity
    @Table(name="users")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {
        @Id
        private Long id;

        private String name;
        private String email;
        private String userName;
        private String password;
        private String role;

        public User(String name,String email,String userName,String password,String role){

            this.name=name;
            this.email=email;
            this.userName=userName;
            this.password=password;
            this.role=role;
        }



    }
