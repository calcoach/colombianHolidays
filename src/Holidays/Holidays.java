/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Holidays;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import util.CalendarUtil;

/**
 *
 * @author Alejandro
 */
public class Holidays {
    
   int year;
   public  Set<LocalDate> holidayDates = new HashSet<>();
   public Map<Integer, String> nameHolidays = new TreeMap<Integer,String>();
   
   
   public Holidays(int year){
       
       this.year = year;
       calculateHolidays();
   }
   
   
   private void calculateHolidays(){
       
       //Domingo de pascua
       LocalDate easterSunday = CalendarUtil.getGregorianEasterSunday(year);
       
       //nuevo año
       LocalDate newYear = LocalDate.of(year, Month.JANUARY, 1);
       this.holidayDates.add(newYear);
       nameHolidays.put(newYear.getDayOfYear(),"Año nuevo");
       
       //reyes magos
       LocalDate wiseMen = LocalDate.of(year, Month.JANUARY, 6);
       wiseMen = moveToMonday(wiseMen);
       this.holidayDates.add(wiseMen);
       
       
       //san jose
       LocalDate saintJose = LocalDate.of(year, Month.MARCH, 19);
       this.holidayDates.add(moveToMonday(saintJose));
       
        //Jueves Santo
       this.holidayDates.add(easterSunday.minusDays(3));
       
       //Viernes Santo
       this.holidayDates.add(easterSunday.minusDays(2));
       
       //Dia del trabajo
       LocalDate workDay = LocalDate.of(year, Month.MAY, 1);
       this.holidayDates.add(workDay);
       
       //Sagrado corazon   
       this.holidayDates.add(moveToMonday(easterSunday.plusDays(68)));
            
       //Ascencion
       this.holidayDates.add(moveToMonday(easterSunday.plusDays(40)));    
       
        //Corpus Cristi
       this.holidayDates.add(moveToMonday(easterSunday.plusDays(60)));
       
       //Dia de la independencia
       LocalDate independendDay = LocalDate.of(year, Month.JULY, 20);
       this.holidayDates.add(independendDay);
       
       //Batalla de boyaca
       LocalDate boyacaBattle = LocalDate.of(year, Month.AUGUST, 7);
       this.holidayDates.add(boyacaBattle);
       
       //Dia de asuncion de la virgen
       LocalDate assuptionMary = LocalDate.of(year, Month.AUGUST, 15);
       this.holidayDates.add(moveToMonday(assuptionMary));
       
       //Dia de la raza
       LocalDate dayOfRace = LocalDate.of(year, Month.OCTOBER, 12);
       this.holidayDates.add(moveToMonday(dayOfRace));
       
       //Todos los Santos
       LocalDate AllOfSaints = LocalDate.of(year, Month.NOVEMBER, 1);
       this.holidayDates.add(moveToMonday(AllOfSaints));
       
       //Independencia de Cartegena
       LocalDate cartagenaIndependency = LocalDate.of(year, Month.NOVEMBER, 11);
       this.holidayDates.add(cartagenaIndependency);
       
       //Inmaculada Concepcion
       LocalDate inmaculateConception = LocalDate.of(year, Month.DECEMBER, 8);
       this.holidayDates.add(inmaculateConception);
       
       //Navidad 
       LocalDate chrismasDay = LocalDate.of(year, Month.DECEMBER, 25);
       this.holidayDates.add(chrismasDay);
       
   }
   
   public String getNameHolidays(LocalDate date){

        return nameHolidays.get(date.getDayOfYear());
    }
   
   public Set<LocalDate> getHolidays(){
       return this.holidayDates;
   }
   
   private LocalDate moveToMonday(LocalDate date){
  
       //DayOfWeek
       int nX = date.getDayOfWeek().getValue();
    
    switch(nX)
        {
        case 2:
          return  date.plusDays(6);
        
        case 3: // Monday
            return  date.plusDays(5);
       
        case 4 : // Tuesday
            return  date.plusDays(4);
       
        case 5 : // Wednesday
            return  date.plusDays(3);
     
        case 6 : // Thursday
            return  date.plusDays(2);
        
        case 7 : // Friday
            return  date.plusDays(1);
        
        default : // Saturday
            return date;
        }
    }
   
   
}
