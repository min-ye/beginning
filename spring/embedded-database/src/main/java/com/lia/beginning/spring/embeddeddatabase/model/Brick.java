package com.lia.beginning.spring.embeddeddatabase.model;

public class Brick {
   private final Long id;
   private final String elementCode;
   private final String designCode;
   private final Long colorId;
   private final Long categoryId;
   private final String name;
   private final String imageUrl;


   public Brick(Long id, String elementCode, String designCode, String name, Long colorId, Long categoryId, String imageUrl ) {
      this.id = id;
      this.elementCode = elementCode;
      this.designCode = designCode;
      this.colorId = colorId;
      this.categoryId = categoryId;
      this.name = name;
      this.imageUrl = imageUrl;
   }
  
   public Long getId() {
      return id;
   }
  
   public String getElementCode() {
      return elementCode;
   }

   public String getDesignCode() {
      return designCode;
   }

   public Long getColorId() {
      return colorId;
   }

   public Long getCategoryId() {
      return categoryId;
   }

   public String getName() {
      return name;
   }

   public String getImageUrl() {
      return imageUrl;
   }

}
