import { BaseEntity, User } from './../../shared';

export const enum Type {
    'SKI',
    'VOILE',
    'PLAGE',
    'SURF',
    'WAKE',
    'VELO',
    'COURSEAPIED'
}

export const enum City {
    'ABBEVILLE',
    'LILLE_LESQUIN',
    'PTE_DE_LA_HAGUE',
    'CAEN_CARPIQUET',
    'ROUEN_BOOS',
    'REIMS_PRUNAY',
    'BREST_GUIPAVAS',
    'PLOUMANACH',
    'RENNES_ST_JACQUES',
    'ALENCON',
    'ORLY',
    'TROYES_BARBEREY',
    'NANCY_OCHEY',
    'STRASBOURG_ENTZHEIM',
    'BELLE_ILE_LE_TALUT',
    'NANTES_BOUGUENAIS',
    'TOURS',
    'BOURGES',
    'DIJON_LONGVIC',
    'BALE_MULHOUSE',
    'PTE_DE_CHASSIRON',
    'POITIERS_BIARD',
    'LIMOGES_BELLEGARDE',
    'CLERMONT_FD',
    'LE_PUY_LOUDES',
    'LYON_ST_EXUPERY',
    'BORDEAUX_MERIGNAC',
    'GOURDON',
    'MILLAU',
    'MONTELIMAR',
    'EMBRUN',
    'MONT_DE_MARSAN',
    'TARBES_OSSUN',
    'ST_GIRONS',
    'TOULOUSE_BLAGNAC',
    'MONTPELLIER',
    'MARIGNANE',
    'CAP_CEPET',
    'NICE',
    'PERPIGNAN',
    'AJACCIO',
    'BASTIA',
    'GLORIEUSES',
    'JUAN_DE_NOVA',
    'EUROPA',
    'TROMELIN',
    'GILLOT_AEROPORT',
    'NOUVELLE_AMSTERDAM',
    'CROZET',
    'KERGUELEN',
    'PAMANDZI',
    'ST_PIERRE',
    'LA_DESIRADE_METEO',
    'ST_BARTHELEMY_METEO',
    'LE_RAIZET_AERO',
    'TRINITE_CARAVEL',
    'LAMENTIN_AERO',
    'SAINT_LAURENT',
    'CAYENNE_MATOURY',
    'SAINT_GEORGES',
    'MARIPASOULA',
    'DUMONT_DURVILLE'
}

export const enum Level {
    'Debutant',
    'Avancee',
    'Professionnel'
}

export class Activity implements BaseEntity {
    constructor(
        public id?: number,
        public type?: Type,
        public city?: City,
        public level?: Level,
        public users?: User[],
    ) {
    }
}
