package ie.gmit;

public class Methods {
    public DataBase dataBase = new DataBase();

    public boolean createAccount(User user){
        return DataBase.users.add(user);
    }

    public User login(String email, String pass){
        for(int i = 0; i< DataBase.users.size(); i++){
            if(DataBase.users.get(i).getEmail().equalsIgnoreCase(email)
            && DataBase.users.get(i).getPassword().equals(pass)){
                return DataBase.users.get(i);
            }
        }
        return null;
    }
    public void matchJobs(Employee employee){
            for(int x=0;x<dataBase.jobs.size();x++){
                for(int i=0;i<employee.getSkills().size();i++){
                    for(int y=0;y<dataBase.jobs.get(x).getSkillList().size();y++){
                    if(employee.getSkills().get(i).getSkillName().equalsIgnoreCase(
                            dataBase.jobs.get(x).getSkillList().get(y).getSkillName()
                    )){

                    }
                }


                //result
            }
        }
    }

}