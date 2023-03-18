import { Injectable, NotFoundException } from '@nestjs/common';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { Factura } from './entities/factura.entity';
import { CreateFacturaDto } from './dto/create-factura.dto';
import { UpdateFacturaDto } from './dto/update-factura.dto';


@Injectable()
export class FacturaService {

  constructor(@InjectRepository(Factura) private repo: Repository<Factura>) { }

  create(createFacturaDto: CreateFacturaDto) {
    const newFactura = this.repo.create(createFacturaDto);
    return this.repo.save(newFactura);
  }

  findAll() {
    return this.repo.findAndCount();
  }

  async findOne(id: number) {
   const factura = await this.repo.findOne({ where: { id } });
    if(!factura) {
      throw new NotFoundException("factura not found")
    }
    return factura;
  }

 
}
