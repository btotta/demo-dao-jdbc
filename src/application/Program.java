package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("-- teste 1 -- seller findByID");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("-- teste 2 -- seller findByDepartment");

		Department department = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("-- teste 3 -- seller findAll");

		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("-- teste 4 -- seller insert");

		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new seller! " + newSeller.getId());

		System.out.println("-- teste 5 -- seller update");
		seller = sellerDao.findById(1);
		seller.setName("Martha W");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("-- teste 6 -- seller delet");
		System.out.println("Enter seller id to delet: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted with sucess " + id);
		
		sc.close();
	}
	
	

}