package lk.carRental.springBoot.service.fileStoreService.impl;

import lk.carRental.springBoot.service.CustomerService;
import lk.carRental.springBoot.service.fileStoreService.StorageService;
import lk.carRental.springBoot.util.StorageException;
import lk.carRental.springBoot.util.StorageFileNotFoundException;
import lk.carRental.springBoot.util.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {


    private  Path rootLocation;

    @Autowired
    CustomerService service;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        System.out.println(this.rootLocation+ " Root");
    }



    @Override
    public String createDirectory(String newDir, String SubDirName) {
        System.out.println(SubDirName);
        Path path = rootLocation;
        //int lastId = Integer.parseInt(SubDirName);
        String mainFolder = "/"+newDir;
        String subFolder = "/"+SubDirName;
        File dri = null;

        System.out.println(path);
        dri = new File(path+mainFolder);
        dri.getAbsolutePath();
        if (!dri.exists()){
             dri = new File(path+mainFolder+subFolder);
             dri.mkdirs();
        }else{
            dri = new File(path+mainFolder+subFolder);
            dri.mkdirs();
            System.out.println("Created file");
        }

        return dri.getPath();
    }

    @Override
    public void store(String path, MultipartFile... files) {

        for(MultipartFile file : files){
            try {
                if (file.isEmpty()) {
                    throw new StorageException("Failed to store empty file.");
                }
                Path destinationFile = Paths.get(path+"/"+Paths.get(file.getOriginalFilename()).normalize());    //this.rootLocation.resolve((Paths.get(file.getOriginalFilename())).normalize());//.toAbsolutePath();
                System.out.println(destinationFile);

			/*if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				// This is a security check
				throw new StorageException(
						"Cannot store file outside current directory.");
			}*/

                try (InputStream inputStream = file.getInputStream()) {
                    Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException e) {
                throw new StorageException("Failed to store file.", e);
            }
        }


    }

    @Override
    public Stream<Path> loadAll()
    {
        return null;
    }

    @Override
    public Path load(String filename) {

        return null;

    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(String fileName, String path ) throws IOException {

        String paths = 	path + "/"+ fileName ;

        try {
            FileSystemUtils.deleteRecursively(Paths.get(paths));
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

        System.out.println("Delete success");

    }

    @Override
    public Resource loadAsResource(String department, String id , String filename) {
        // file name or All , witch department , customer Id

        try {
            //Path file = load(filename);
            //  System.out.println(file.resolve(""));
            System.out.println(rootLocation.toUri());
            //"file:///home/abeehaheshan/Desktop/img"
            Resource resource = new UrlResource(rootLocation.toUri()+ "/" + department + "/" + id + "/" + filename);
            System.out.println(resource+" XDEW");


            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);
            }
        }

        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }

    }
}
