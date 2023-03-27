package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Piece;
import com.example.pierp.Repositories.PieceRepository;
import com.example.pierp.Services.PieceService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PieceServiceImpl implements PieceService {

    @Autowired
    PieceRepository pieceRepository;
    @Override
    public boolean addPiece(Piece piece) {
        try {
            pieceRepository.save(piece);
            System.out.println("Piece added successfully");
            return true;
        } catch (Exception e) {
            System.out.println("Cause: "+e.getCause()+" \n Message  : "+e.getMessage());
            return false;
        }
    }

    @Override
    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    @Override
    public boolean updatePiece(String reference,int Qte) {
        try {
             Piece piece = pieceRepository.findById(reference).get();
                piece.setQteStock(piece.getQteStock()-Qte);
                pieceRepository.saveAndFlush(piece);
                System.out.println("Piece updated successfully");
            return true ;
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause() + " \n Message  : " + e.getMessage());
            return false;
        }
    }
    @Override
    public Piece getPiece(String reference) {

        return  pieceRepository.findById(reference).get();
    }


    //TODO : don't forget me please
    @Override
    public boolean ImportPieceCsv(MultipartFile file) throws IOException {
        int i = 0 ;
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        while (i < sheet.getLastRowNum()) {
            //TODO : modify the code to get the right data
            Piece piece = new Piece();
            piece.setReference(sheet.getRow(i).getCell(0).getStringCellValue());
            piece.setDesignation(sheet.getRow(i).getCell(1).getStringCellValue());
            piece.setQteStock((int) sheet.getRow(i).getCell(2).getNumericCellValue());
            piece.setPrixVenteHt(sheet.getRow(i).getCell(3).getNumericCellValue());
            piece.setfConstructeur(sheet.getRow(i).getCell(4).getStringCellValue());
            pieceRepository.save(piece);
            i++;
        }

        return true;
    }
}
