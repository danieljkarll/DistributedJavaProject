package dao;


import hibernate.entity.Gender

public interface GenderDAO {
    void createGender(String genderName);

    int getGenderId(int genderId);

    void updateGender(int id, String updateGender);

    void deleteGender(int)


    private void updateGender(int id, String updatedGender) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        //TO DO if deleting gender delete gender from
        // all of the person entities and replace it
        Gender gender = session.get(Gender.class, id);
        gender.setGender(updatedGender);

        session.getTransaction().commit();
    }
    private void deleteGender(int genderID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Gender doomedGender = session.get(Gender.class, genderID);

        if (doomedGender == null){
            System.out.println("No gender for ID " + doomedGender);
        } else {
            session.delete(doomedGender);
        }

        session.getTransaction().commit();
    }
}
