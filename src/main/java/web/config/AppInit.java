    package web.config;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityManagerFactory;
    import jakarta.persistence.Persistence;
    import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

        // Метод, указывающий на класс конфигурации
        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }


        // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[]{
                    WebConfig.class
            };
        }


        /* Данный метод указывает url, на котором будет базироваться приложение */
        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }


        private static EntityManagerFactory entityManagerFactory;

        static {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            } catch (Throwable ex) {
                System.err.println("Initial EntityManagerFactory creation failed." + ex);
                ex.printStackTrace();
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static EntityManager getEntityManager() {
            return entityManagerFactory.createEntityManager();
        }

        public static void closeEntityManager() {
            if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
            }
        }
    }
