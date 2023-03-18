import { Module } from '@nestjs/common';

import { FacturaService } from './factura.service';
import { FacturaController } from './factura.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Factura } from './entities/factura.entity';

@Module({
  imports: [TypeOrmModule.forRoot({
    type: 'sqlite',
    database: 'db.sqlite',
    entities: [Factura],
    synchronize: true,
  }), TypeOrmModule.forFeature([Factura]) ],
  controllers: [FacturaController],
  providers: [FacturaService]
})
export class FacturaModule { }
